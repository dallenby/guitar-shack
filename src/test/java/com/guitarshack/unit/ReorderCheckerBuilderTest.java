package com.guitarshack.unit;

import com.guitarshack.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ReorderCheckerBuilderTest {

    ReorderChecker reorderChecker;

    @Before
    public void setup(){
        ReorderCheckerBuilder reorderCheckerBuilder = new ReorderCheckerBuilder();
        reorderChecker = reorderCheckerBuilder.build();
    }

    @Test
    public void ReorderCheckerBuilderReturnReorderChecker(){
        assertThat(reorderChecker.getClass(), equalTo(ReorderChecker.class));
    }
}
