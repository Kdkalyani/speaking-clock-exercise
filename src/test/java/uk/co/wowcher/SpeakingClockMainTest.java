package uk.co.wowcher;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SpeakingClockMainTest {
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void whenEnteredLettersInsteadOfIntegers_thenShouldReturnException() {
		exceptionRule.expect(NumberFormatException.class);
		exceptionRule.expectMessage("You need to pass a valid 24 hour format hour");
		SpeakingClockMain speakingClockMain = new SpeakingClockMain();
		String result = speakingClockMain.getDetails("12:aa");
		System.out.println(result);
	}

	@Test
	public void whenEnteredSemicolonInsteadOfColon_thenShouldReturnException() {
		exceptionRule.expect(NumberFormatException.class);
		exceptionRule.expectMessage("You need to pass a valid 24 hour format hour");
		SpeakingClockMain speakingClockMain = new SpeakingClockMain();
		String result = speakingClockMain.getDetails("12;13");
		System.out.println(result);
	}

	@Test
	public void whenEnteredMidday_thenShouldReturnItsMidday() {
		SpeakingClockMain speakingClockMain = new SpeakingClockMain();
		String result = speakingClockMain.getDetails("12:00");
		assertEquals("It's Midday", result);
	}

	@Test
	public void whenEnteredMidnight_thenShouldReturnItsMidnight() {
		SpeakingClockMain speakingClockMain = new SpeakingClockMain();
		String result = speakingClockMain.getDetails("24:00");
		assertEquals("It's Midnight", result);
	}

	@Test
	public void whenEnteredTwelveFifty_thenShouldReturnItsTwelveFifty() {
		SpeakingClockMain speakingClockMain = new SpeakingClockMain();
		String result = speakingClockMain.getDetails("12:50");
		assertEquals("It's twelve fifty ", result);
	}

	@Test
	public void whenEnteredOne_thenShouldReturnItsOne() {
		SpeakingClockMain speakingClockMain = new SpeakingClockMain();
		String result = speakingClockMain.getDetails("13:00");
		assertEquals("It's one ", result);
	}

	@Test
	public void whenEnteredTwoOhSix_thenShouldReturnItsTwoOhSix() {
		SpeakingClockMain speakingClockMain = new SpeakingClockMain();
		String result = speakingClockMain.getDetails("14:06");
		assertEquals("It's two oh six ", result);
	}

	@Test
	public void whenEnteredFiveFifteen_thenShouldReturnItsFiveFifteen() {
		SpeakingClockMain speakingClockMain = new SpeakingClockMain();
		String result = speakingClockMain.getDetails("17:15");
		assertEquals("It's five fifteen ", result);
	}
}
