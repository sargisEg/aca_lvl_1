package com.homework.week8.checked.unchecked.exceptions;

import com.aca.homework.week8.checked.unchecked.exceptions.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void method5Test() {
        Assertions.assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Main.method5();
            }
        });
    }

    @Test
    public void method4Test() {
        Assertions.assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Main.method4();
            }
        });
    }
    @Test
    public void method3RunTimeExceptionTest() {
        Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Main.method3();
            }
        });
    }
    @Test
    public void method3ExceptionTest() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class,new Executable() {
            @Override
            public void execute() throws Throwable {
                Main.method3();
            }
        });
        Assertions.assertNotEquals(Exception.class,exception);
    }
    @Test
    public void method2Test() {
        Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Main.method2();
            }
        });
    }
    @Test
    public void method1Test() {
        Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Main.method1();
            }
        });
    }
    @Test
    public void mainTest() {
        Assertions.assertDoesNotThrow( new Executable() {
            @Override
            public void execute() throws Throwable {
                Main.main(null);
            }
        });
    }

}