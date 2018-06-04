package com.bts.java8.samples.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Sample1 {
	
	private static final String REGEX = "^[A-Za-z0-9+._-]+@(.+)$";

	public static void main(String[] args) {

		Optional<String> optional = Optional.of("birla");

		// 1. Checking value with isPresent() to avoid null check in the code
		System.out.println(
				"Checking value with isPresent() :" + optional.isPresent());
		System.out.println();

		// 2.Returning value with get()
		System.out.println("Returning value with get() :" + optional.get());
		System.out.println();

		// 3. Default value with orElse() ( or ) orElseGet()
		// Diff between the orElse and orElseGet:
		// In case of orElse, Default value is created, whether the wrapped
		// value is present or not.
		// In Case of orElseGet, Default value is created only if the wrapped
		// value is not present.
		optional = Optional.ofNullable(null);
		System.out.println(
				"Default value with orElse() :" + optional.orElse("default"));
		System.out.println("Default value with orElseGet() :"
				+ optional.orElseGet(() -> "default"));
		System.out.println();

		// 4. Exceptions with orElseThrow
		try {
			Optional.ofNullable(null).orElseThrow(NullPointerException::new);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exceptions with orElseThrow :" + e);
			System.out.println();
		}

		// 5. Checking conditional return with filter()
		System.out.println("Checking conditional return with filter() :"
				+ Optional.ofNullable("birla").filter(n -> n.equals("birla"))
						.isPresent());
		System.out.println("Checking conditional return with filter() :"
				+ Optional.ofNullable("birla").filter(n -> n.equals("birla1"))
						.isPresent());
		System.out.println();

		// 6. Transforming Value with map()
		List<String> emailList = Arrays.asList("test1@gmail.com",
				"test_2@gmail.com", "Test-3@gmail.com", "test##4@gmail.com",
				"test.5@gmail.com", "test$6@gmail.com", "test7",
				"test8@gmail.com");
		List<String> validEmails = Optional.ofNullable(emailList).map(email -> getValidEmails(email)).get();
		System.out.println("Transforming Value with map() :"+validEmails);

		// 7. Transforming Value with flatMap()
		//TODO Here

	}

	private static List<String> getValidEmails(List<String> emails) {
		return emails.stream().filter(email -> isEmailValid(email))
				.collect(Collectors.toList());
	}

	private static boolean isEmailValid(String email) {
		
		Pattern pattern = Pattern.compile(REGEX);
		return pattern.matcher(email).matches();
	}

}
