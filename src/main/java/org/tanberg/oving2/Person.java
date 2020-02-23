package org.tanberg.oving2;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class Person {

	private static final int[] F = { 3, 7, 6, 1, 8, 9, 4, 5, 2 };
	private static final int[] G = { 5, 4, 3, 2, 7, 6, 5, 4, 3, 2 };

	private static final Pattern NAME_PATTERN = Pattern.compile("[a-zA-Z]");
	private static final Pattern EMAIL_PATTERN = Pattern
			.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");

	private static final String[] LEGAL_DOMAINS = { "ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as",
			"at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo",
			"bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm",
			"cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg",
			"eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi",
			"gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id",
			"ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km",
			"kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma",
			"mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv",
			"mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa",
			"pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru",
			"rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st",
			"sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv",
			"tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye",
			"yt", "za", "zm", "zw" };

	private String firstName;
	private String lastName;
	private Date birthday;
	private String email;
	private Gender gender;
	private String ssn;

	public Person() {
		this.gender = Gender.UNKNOWN;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.verifyEmail(email);

		this.email = email;
	}

	public String getName() {
		return this.firstName + " " + this.lastName;
	}

	public void setName(String name) {
		String[] nameParts = name.split(" ");
		if (nameParts.length != 2 || nameParts[0].length() < 2 || nameParts[1].length() < 2) {
			throw new IllegalArgumentException();
		}

		if (!nameParts[0].matches("^\\s*[\\da-zA-Z][\\da-zA-Z\\s]*$")
				|| !nameParts[1].matches("^\\s*[\\da-zA-Z][\\da-zA-Z\\s]*$")) {
			throw new IllegalArgumentException();
		}

		this.firstName = nameParts[0];
		this.lastName = nameParts[1];
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public char getGender() {
		return this.gender.getId();
	}

	public void setGender(char id) {
		this.gender = Gender.byId(id);
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		if (birthday.getTime() > System.currentTimeMillis()) {
			throw new IllegalArgumentException("Birthday in the future???");
		}

		this.birthday = birthday;
	}

	public String getSSN() {
		return this.ssn;
	}

	public void setSSN(String ssn) {
		if (ssn.length() != 11) {
			throw new IllegalArgumentException("Invalid SSN!");
		}

		if (this.gender == Gender.UNKNOWN || this.birthday == null) {
			throw new IllegalStateException("Can't set SSN without birthday and gender!");
		}

		this.verifySSN(ssn, Long.valueOf(ssn));
		this.ssn = ssn;
	}

	// Verification methods

	private void verifySSN(String ssnStr, long ssn) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.getBirthday());

		int ssnDate = (int) (ssn / 1000000000L);
		if (ssnDate != calendar.get(Calendar.DAY_OF_MONTH)) {
			throw new IllegalArgumentException("Invalid SSN");
		}

		int ssnMonth = (int) ((ssn % 1000000000L) / 10000000L) - 1;
		if (ssnMonth != calendar.get(Calendar.MONTH)) {
			throw new IllegalArgumentException("Invalid SSN");
		}
 
		int ssnYear = (int) ((ssn % 10000000L) / 100000L);
		if (ssnYear != (calendar.get(Calendar.YEAR) % 100)) {
			throw new IllegalArgumentException("Invalid SSN");
		}

		int randos = (int) ((ssn % 100000L) / 100L);
		if (this.gender == Gender.MALE && randos % 2 == 0 || this.gender == Gender.FEMALE && randos % 2 != 0) {
			throw new IllegalArgumentException("Invalid SSN");
		}

		char[] ssnChars = ssnStr.toCharArray();

		int fVerification = (int) ((ssn % 100L) / 10L);
		int gVerification = (int) (ssn % 10L);

		int fSum = 0;
		int gSum = 0;
		for (int i = 0; i < 10; i++) {
			int numVal = Character.getNumericValue(ssnChars[i]);
			if (i < 9) {
				fSum += (F[i] * numVal);
			}

			gSum += (G[i] * numVal);
		}

		fSum = (11 - (fSum % 11)) % 11;
		gSum = (11 - (gSum % 11)) % 11;
		
		if (fSum != fVerification || gSum != gVerification) {
			throw new IllegalArgumentException("Invalid SSN");
		}
	}

	private void verifyEmail(String email) {
		if (email == null) {
			return;
		}

		if (!EMAIL_PATTERN.matcher(email).matches()) {
			throw new IllegalArgumentException("Invalid email \"" + email + "\"!");
		}

		if (!email.startsWith(this.firstName.toLowerCase() + "." + this.lastName.toLowerCase())) {
			throw new IllegalArgumentException("Invalid email!");
		}

		int lastDot = email.lastIndexOf('.');
		String suffix = email.substring(lastDot + 1, email.length());
		if (Arrays.stream(LEGAL_DOMAINS).noneMatch(legal -> legal.equalsIgnoreCase(suffix))) {
			throw new IllegalArgumentException("Invalid domain suffix!");
		}
	}

}
