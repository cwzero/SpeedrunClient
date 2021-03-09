package com.liquidforte.speedrun.test;

import com.liquidforte.speedrun.client.Time;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class TimeTests {
    @Test
    public void testHours() {
        Time a = new Time(1, 0, 0);
        Time b = new Time(2, 0, 0);
        assertThat(a.compareTo(b)).isEqualTo(-1);
    }

    @Test
    public void testHoursVsMinutes() {
        Time a = new Time(1, 0, 0);
        Time b = new Time(0, 2, 0);
        assertThat(a.compareTo(b)).isEqualTo(1);
    }

    @Test
    public void testHoursVsSeconds() {
        Time a = new Time(1, 0, 0);
        Time b = new Time(0, 0, 2);
        assertThat(a.compareTo(b)).isEqualTo(1);
    }

    @Test
    public void testMinutes() {
        Time a = new Time(0, 1, 0);
        Time b = new Time(0, 2, 0);
        assertThat(a.compareTo(b)).isEqualTo(-1);
    }

    @Test
    public void testMinutesVsSeconds() {
        Time a = new Time(0, 1, 0);
        Time b = new Time(0, 0, 2);
        assertThat(a.compareTo(b)).isEqualTo(1);
    }

    @Test
    public void testSeconds() {
        Time a = new Time(0, 0, 1);
        Time b = new Time(0, 0, 2);
        assertThat(a.compareTo(b)).isEqualTo(-1);
    }
}
