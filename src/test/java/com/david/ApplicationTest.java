package com.david;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class ApplicationTest {

  @Test
  public void firstNonMockTest(){

    User user = new User("David", "Orelowitz");
    assertEquals("David Orelowitz", user.getFullName());
  }

  @Test
  public void MockStubTest(){
    User userMock = mock(User.class);
    when(userMock.getFullName()).thenReturn("David Orelowitz");
    assertEquals("David Orelowitz", userMock.getFullName());

    when(userMock.getFullName()).thenReturn("David O");
    assertEquals("David O", userMock.getFullName());

    when(userMock.getFullName()).thenReturn("David Orrie");
    assertEquals("David Orrie", userMock.getFullName());

    verify(userMock, times(3)).getFullName();
    verify(userMock, times(0)).setFirstName("David");
  }
}
