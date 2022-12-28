package mk.finki.ukim.mk.lab;

import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.model.enumType.Role;
import mk.finki.ukim.mk.lab.model.exceptions.InvalidUsernameOrPassword;
import mk.finki.ukim.mk.lab.model.exceptions.PasswordsDontMatchException;
import mk.finki.ukim.mk.lab.model.exceptions.UsernameExistsException;
import mk.finki.ukim.mk.lab.repository.jpa.UserRepository;
import mk.finki.ukim.mk.lab.service.impl.UserServiceImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
public class UserRegistrationTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;


    private UserServiceImplementation  userServiceImplementation;
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        User user = new User("username", "password", "name", "surname");
        Mockito.when(this.userRepository.save(Mockito.any(User.class))).thenReturn(user);
        Mockito.when(this.passwordEncoder.encode(Mockito.anyString())).thenReturn("password");
        this.userServiceImplementation = Mockito.spy(new UserServiceImplementation(this.userRepository, this.passwordEncoder));
    }
    @Test
    public void testSuccessRegister(){
        User user = this.userServiceImplementation.register("username","password","password","name","surname", Role.ROLE_USER);
        Mockito.verify(this.userServiceImplementation).register("username","password","password","name","surname", Role.ROLE_USER);
        Assert.assertNotNull("User is not null",user);
        Assert.assertEquals("name do not match","name",user.getUserFullName().getName());
        Assert.assertEquals("username do not match","username",user.getUsername());
        Assert.assertEquals("pass do not match","password",user.getPassword());
    }
    @Test
    public void testNullUsername(){
        String username = "";
        Assert.assertThrows("InvalidUsernameOrPassword  expected",InvalidUsernameOrPassword .class, () -> this.userServiceImplementation.register(null,"password","password","name","surname", Role.ROLE_USER));
        Mockito.verify(this.userServiceImplementation).register(null,"password","password","name","surname", Role.ROLE_USER);
    }
    @Test
    public void testEmptyUsername(){
        String username = "";
        Assert.assertThrows("InvalidUsernameOrPassword  expected",InvalidUsernameOrPassword .class, () -> this.userServiceImplementation.register(username,"password","password","name","surname", Role.ROLE_USER));
        Mockito.verify(this.userServiceImplementation).register(username,"password","password","name","surname", Role.ROLE_USER);

    }
    @Test
    public void testEmptyPassword() {
        String username = "username";
        String password = "";
        Assert.assertThrows("InvalidUsernameOrPassword expected",
                InvalidUsernameOrPassword.class,
                () -> this.userServiceImplementation.register(username, password, "password", "name", "surname", Role.ROLE_USER));
        Mockito.verify(this.userServiceImplementation).register(username, password, "password", "name", "surname", Role.ROLE_USER);

    }
    @Test
    public void testNullPassword() {
        String username = "username";
        String password = null;
        Assert.assertThrows("InvalidUsernameOrPassword  expected",
                InvalidUsernameOrPassword .class,
                () -> this.userServiceImplementation.register(username, password, "password", "name", "surname", Role.ROLE_USER));
        Mockito.verify(this.userServiceImplementation).register(username, password, "password", "name", "surname", Role.ROLE_USER);

    }

    @Test
    public void testPasswordMismatch() {
        String username = "username";
        String password = "password";
        String confirmPassword = "otherPassword";
        Assert.assertThrows("PasswordsDontMatchException expected",
                PasswordsDontMatchException.class,
                () -> this.userServiceImplementation.register(username, password, confirmPassword, "name", "surname", Role.ROLE_USER));
        Mockito.verify(this.userServiceImplementation).register(username, password, confirmPassword, "name", "surname", Role.ROLE_USER);
    }


    @Test
    public void testDuplicateUsername() {
        User user = new User("username", "password", "name", "surname");
        Mockito.when(this.userRepository.findByUsername(Mockito.anyString())).thenReturn(Optional.of(user));
        String username = "username";
        Assert.assertThrows("UsernameExistsException expected",
                UsernameExistsException.class,
                () -> this.userServiceImplementation.register(username, "password", "password", "name", "surname", Role.ROLE_USER));
        Mockito.verify(this.userServiceImplementation).register(username, "password", "password", "name", "surname", Role.ROLE_USER);
    }
}
