package org.eviewhite.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.io.IOException;

import java.util.Scanner;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class MenuMockTest {

    @Mock
    private Scanner mockScanner;
    private Menu menuUnderTest;

    @BeforeEach
    void init() throws IOException {
        MockitoAnnotations.openMocks(this);
        menuUnderTest = spy(new Menu(mockScanner));

        doNothing().when(menuUnderTest).optViewSquad();
        doNothing().when(menuUnderTest).optViewPlayer();
        doNothing().when(menuUnderTest).optViewMatches();
        doNothing().when(menuUnderTest).optUpdateMatch();
    }

    @Test
    void testGameMenu_Option1_CallsOptViewSquad() throws IOException {
        when(mockScanner.nextInt()).thenReturn(1).thenReturn(5);
        when(mockScanner.nextLine()).thenReturn("N");

        menuUnderTest.gameMenu();

        verify(menuUnderTest, times(1)).optViewSquad();
    }

    @Test
    void testGameMenu_Option2_CallsOptViewPlayer() throws IOException {
        when(mockScanner.nextInt()).thenReturn(2).thenReturn(5);
        when(mockScanner.nextLine()).thenReturn("N");

        menuUnderTest.gameMenu();

        verify(menuUnderTest, times(1)).optViewPlayer();
    }

    @Test
    void testGameMenu_Option3_CallsOptViewMatches() throws IOException {
        when(mockScanner.nextInt()).thenReturn(3).thenReturn(5);
        when(mockScanner.nextLine()).thenReturn("N");

        menuUnderTest.gameMenu();

        verify(menuUnderTest, times(1)).optViewMatches();
    }

    @Test
    void testGameMenu_Option4_CallsOptUpdateMatch() throws IOException {
        when(mockScanner.nextInt()).thenReturn(4).thenReturn(5);
        when(mockScanner.nextLine()).thenReturn("N");

        menuUnderTest.gameMenu();

        verify(menuUnderTest, times(1)).optUpdateMatch();
    }

    @Test
    void testGameMenu_Option5_Exit() throws IOException{
        when(mockScanner.nextInt()).thenReturn(5);
        menuUnderTest.gameMenu();

        verify(mockScanner, times(1)).close();
    }

    @Test
    void testGameMenu_ContinueGame() throws IOException{
        when(mockScanner.nextInt()).thenReturn(1).thenReturn(2).thenReturn(5);
        when(mockScanner.nextLine()).thenReturn("Y").thenReturn("N");

        menuUnderTest.gameMenu();

        verify(menuUnderTest, times(1)).optViewSquad();
    }
}
