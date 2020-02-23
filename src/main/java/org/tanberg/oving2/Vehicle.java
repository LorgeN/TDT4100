package org.tanberg.oving2;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Vehicle {
	
	private static final Pattern PATTERN = Pattern.compile("[A-Z]{2}[0-9]{4,5}");

	private final VehicleType vehicleType;
	private final FuelType fuelType;
	private String registration;

	public Vehicle(char vehicleType, char fuelType, String registration) {
		this(VehicleType.fromChar(vehicleType), FuelType.fromChar(fuelType), registration);
	}
	
	public Vehicle(VehicleType vehicleType, FuelType fuelType, String registration) {
		this.vehicleType = vehicleType;
		this.fuelType = fuelType;
		
		if (this.vehicleType == VehicleType.MOTORCYCLE && this.fuelType == FuelType.HYDROGEN) {
			throw new IllegalArgumentException("Unsupported fuel type for vehicle type!");
		}

		this.validateRegistration(registration);
		
		this.registration = registration;
	}
	
	public char getFuelType() {
		return this.fuelType.getId();
	}
	
	public char getVehicleType() {
		return this.vehicleType.getId();
	}

	public String getRegistrationNumber() {
		return registration;
	}

	public void setRegistrationNumber(String registration) {
		this.validateRegistration(registration);
		
		this.registration = registration;
	}

	private void validateRegistration(String registration) {
		String directionId = registration.substring(0, 2);
		if ((directionId.equals("EL") || directionId.equals("EK")) && this.fuelType != FuelType.ELECTRIC) {
			throw new IllegalArgumentException(
					"Vehicle is not electric! Registration \"" + registration + "\" invalid!");
		}

		if (!(directionId.equals("EL") || directionId.equals("EK")) && this.fuelType == FuelType.ELECTRIC) {
			throw new IllegalArgumentException(
					"Vehicle is electric! Registration \"" + registration + "\" invalid!");	
		}
		
		if (directionId.equals("HY") && this.fuelType != FuelType.HYDROGEN) {
			throw new IllegalArgumentException(
					"Vehicle is not powered by hydrogen! Registration \"" + registration + "\" invalid!");
		}

		if (!directionId.equals("HY") && this.fuelType == FuelType.HYDROGEN) {
			throw new IllegalArgumentException(
					"Vehicle is powered by hydrogen! Registration \"" + registration + "\" invalid!");
		}
		
		if (!PATTERN.matcher(registration).matches()) {
			throw new IllegalArgumentException("Registration \"" + registration + "\" invalid!");	
		}

		String num = registration.substring(2, registration.length());
		try {
			Integer.parseInt(num);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Registration \"" + registration + "\" invalid!");
		}
		
		if (num.length() != 4 && this.vehicleType == VehicleType.MOTORCYCLE) {
			throw new IllegalArgumentException("Invalid length! Registration \"" + registration + "\" invalid!");
		}
		
		if (num.length() != 5 && this.vehicleType == VehicleType.CAR) {
			throw new IllegalArgumentException("Invalid length! Registration \"" + registration + "\" invalid!");
		}
	}

	public enum VehicleType {
		CAR('C'), MOTORCYCLE('M');

		private final char id;

		VehicleType(char id) {
			this.id = id;
		}

		public char getId() {
			return this.id;
		}

		public static VehicleType fromChar(char ch) {
			return Arrays.stream(VehicleType.values()).filter(type -> type.getId() == ch).findFirst()
					.orElseThrow(() -> new IllegalArgumentException("Invalid vehicle type " + ch));
		}
	}

	public enum FuelType {
		GAS('G'), DIESEL('D'), ELECTRIC('E'), HYDROGEN('H');

		private final char id;

		FuelType(char id) {
			this.id = id;
		}

		public char getId() {
			return this.id;
		}

		public static FuelType fromChar(char ch) {
			return Arrays.stream(FuelType.values()).filter(type -> type.getId() == ch).findFirst()
					.orElseThrow(() -> new IllegalArgumentException("Invalid fuel type " + ch));
		}
	}
}
