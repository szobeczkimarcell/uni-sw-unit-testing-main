package uni.sw.unit.testing.mocking;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import uni.sw.unit.testing.user.User;
import uni.sw.unit.testing.user.UserDatabase;
import uni.sw.unit.testing.user.UserManager;


public class UserTest {

    @Test
    @DisplayName("testing default values for the user object")
    public void defaultConstructorTest() {
       //Create user object with default constructor
       User defaultUser = new User();

       assertNotNull(defaultUser, "User object should not be null");
       assertNull(defaultUser.getUserName(), "UserName should be null");
       assertNull(defaultUser.getPassword(), "Password should be null");
       assertEquals(0, defaultUser.getId() ,"Id should be 0");
       assertThrows(
            UnsupportedOperationException.class, 
            defaultUser::isLoggedIn, 
            "method should throw an UnsupportedOperationException"
        );
    }


    //Mockito test example   
    @Test
    @ExtendWith(MockitoExtension.class)
    public void mockTest() {
        //Mock the User class
        User mockUser = Mockito.mock(User.class);
        
        // Mock the behavior of getUserName method
        when(mockUser.getUserName()).thenReturn("TesztElek");
        assertEquals("TesztElek", mockUser.getUserName(), "UserName should be TesztElek");

        // Mock the behavior of getPassword method
        when(mockUser.getPassword()).thenReturn("TOPSECRET");
        assertEquals("TOPSECRET", mockUser.getPassword(), "PassWord should be TOPSECRET");

        // Mock the behavior of isLoggedIn method
        when(mockUser.isLoggedIn()).thenReturn(true);
        assertTrue(mockUser.isLoggedIn(), "LoggedIn should be true");

        // Mock the behavior of getId method
        when(mockUser.getId()).thenReturn(123);
        assertEquals(123,mockUser.getId(), "Id should be 123");

        // Verify the methods were called
        verify(mockUser).getUserName();
        verify(mockUser).getPassword();
        verify(mockUser).isLoggedIn();
        verify(mockUser).getId();

        //times(int) example
        assertEquals(9,mockUser.getPassword().length());
        verify(mockUser, times(2)).getPassword();

        //doThrow example
        doThrow(new UnsupportedOperationException()).when(mockUser).isLoggedIn();
        assertThrows(
            UnsupportedOperationException.class, 
            mockUser::isLoggedIn, 
            "method should throw an UnsupportedOperationException"
        );

        //any example
        when(mockUser.getAcademicAverage(anyInt())).thenReturn(4.6);
        assertEquals(4.6, mockUser.getAcademicAverage(2));
        assertEquals(4.6, mockUser.getAcademicAverage(3));

    
        //additional training tasks 
        when (mockUser.update(anyString(), eq(false))).thenReturn(false);
        assertFalse(mockUser.update("newPassword", false), "False value should be returned");
        verify(mockUser).update("newPassword", false);

        doThrow(new IllegalArgumentException()).when(mockUser).update(anyString(), anyBoolean());
        assertThrows(
            IllegalArgumentException.class,
           () -> {mockUser.update("SOMETHING", true);}
        );
    }

    
    //@InjectMocks example
    
    @Mock User user;
    @Mock UserDatabase userDatabase;
    @InjectMocks UserManager userManager;


    @Test
    @ExtendWith(MockitoExtension.class)
    public void injecttest() {
        userManager.initialize();
    }


}
