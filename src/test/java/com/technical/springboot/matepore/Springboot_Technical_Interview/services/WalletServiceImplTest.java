package com.technical.springboot.matepore.Springboot_Technical_Interview.services;

import com.technical.springboot.matepore.Springboot_Technical_Interview.dto.DollarResponse;
import com.technical.springboot.matepore.Springboot_Technical_Interview.dto.WalletDto;
import com.technical.springboot.matepore.Springboot_Technical_Interview.entities.Wallet;
import com.technical.springboot.matepore.Springboot_Technical_Interview.exceptions.WalletNotFoundException;
import com.technical.springboot.matepore.Springboot_Technical_Interview.repositories.WalletRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@Tag("test of wallet service")
@ExtendWith(MockitoExtension.class)
class WalletServiceImplTest {
    @Mock
    private WalletRepository wRepository;

    @Mock
    private DollarService dollarService;

    @InjectMocks
    private WalletServiceImpl walletService;

    @Nested
    @Tag("Methods")
    class MethodsTests{
        @Test
        @DisplayName("test of the function create of wallet")
        void test_create_wallet() {
            when(wRepository.save(any())).thenReturn(ExampleData.WALLET001);

            WalletDto result = walletService.create(ExampleData.WALLET_DTO001);

            assertThat(result).isNotNull();
            assertThat(result.getId())
                    .as("The id received is different from the expected.")
                    .isEqualTo(1L);
            assertEquals(30.0, result.getSalary());

            verify(wRepository).save(any(Wallet.class));
        }

        @Test
        @DisplayName("test of the function list of wallet")
        void test_list_wallet() {
            when(wRepository.findAll()).thenReturn(ExampleData.WALLETS);

            List<WalletDto> result = walletService.list();

            assertNotNull(result);
            assertEquals(3, result.size());
            verify(wRepository).findAll();
        }

        @Test
        @DisplayName("test of the function findById of wallet")
        void test_find_by_id_wallet() {
            when(wRepository.findById(2L)).thenReturn(Optional.of((ExampleData.WALLET002)));

            WalletDto result = walletService.findById(2L);

            assertNotNull(result);
            assertEquals(2L, result.getId());
            assertEquals(40.0, result.getSalary());
            assertEquals(23.0, result.getSalaryInDollars());

            verify(wRepository).findById(anyLong());
        }

        @Test
        @DisplayName("test of the function update of wallet")
        void test_update_wallet() {
            Wallet existingWallet = ExampleData.WALLET001;
            WalletDto updateDto = ExampleData.WALLET_DTO001;
            updateDto.setSalary(2000.0);

            DollarResponse mockDollar = new DollarResponse();
            mockDollar.setCompra((int) 2.0);

            when(wRepository.findById(existingWallet.getId())).thenReturn(Optional.of(existingWallet));
            when(dollarService.getBlue()).thenReturn(mockDollar);

            //Invocation argument indicates that the returned answer gives the wallet that was passed in the save. In this case we only have one argument, so 0 is the correct value.
            when(wRepository.save(any(Wallet.class))).thenAnswer(invocation -> invocation.getArgument(0));

            WalletDto result = walletService.update(existingWallet.getId(), updateDto);

            assertNotNull(result);
            assertEquals(existingWallet.getId(), result.getId());
            assertEquals(2000.0, result.getSalary());
            assertEquals(4000.0, result.getSalaryInDollars());

            verify(wRepository).findById(existingWallet.getId());
            verify(wRepository).save(existingWallet);
            verify(dollarService).getBlue();
        }

        @Test
        void test_delete_wallet() {
            when(wRepository.existsById(1L)).thenReturn(true);
            doNothing().when(wRepository).deleteById(1L);

            walletService.delete(1L);

            verify(wRepository).deleteById(1L);
        }
    }

    @Nested
    @Tag("Exceptions")
    class ExceptionTests{
        @Test
        @DisplayName("test if the exception is working when no wallet is found")
        void test_find_by_id_not_found_exception() {
            //We return an empty to simulate when the id is not present in the table.
            when(wRepository.findById(555L)).thenReturn(Optional.empty());

            assertThrows(WalletNotFoundException.class, () -> walletService.findById(555L));
            verify(wRepository).findById(555L);
        }

        @Test
        @DisplayName("test with a similar case to findById, just to see if the exception is working")
        void test_update_not_found_exception() {
            when(wRepository.findById(555L)).thenReturn(Optional.empty());

            assertThrows(WalletNotFoundException.class, () -> walletService.update(555L, ExampleData.WALLET_DTO001));
        }

        @Test
        @DisplayName("test if the WalletNotFoundException works with the delete function")
        void test_delete_not_found_exception() {
            when(wRepository.existsById(555L)).thenReturn(false);

            assertThrows(WalletNotFoundException.class, () -> walletService.delete(555L));
        }
    }
}