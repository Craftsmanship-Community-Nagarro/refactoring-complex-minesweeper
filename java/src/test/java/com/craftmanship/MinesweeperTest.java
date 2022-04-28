package com.craftmanship;

import org.approvaltests.reporters.JunitReporter;
import org.approvaltests.reporters.UseReporter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

@UseReporter(JunitReporter.class)
public class MinesweeperTest {

    @Test
    public void shouldTestEnoughToStartRefactoring() throws FileNotFoundException {
        Assertions.assertThat("Missing tests").isEqualTo("are added");
    }

}
