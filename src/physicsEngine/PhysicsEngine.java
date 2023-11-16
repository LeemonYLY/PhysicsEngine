package physicsEngine;

// A physics engine 
// that simulates the movement of objects in the vertical direction and calculates their associated physics parameters
public class PhysicsEngine {

	public static void main(String[] args) {
		// Input parameters and suggested ranges:
		// args[0]: initialPosition - Initial position (unit: meters), Suggested Range:
		// Any real number
		// args[1]: finalPosition - Final position (unit: meters), Suggested Range: Any
		// real number
		// args[2]: initialTime - Initial time (unit: seconds), Suggested Range: Any
		// real number
		// args[3]: finalTime - Final time (unit: seconds), Suggested Range: Any real
		// number

		if (args.length != 4) {
			System.err.println("Please enter four parameters: initialPosition, finalPosition, initialTime, finalTime");
			return;
		}

		double initialPosition = Double.parseDouble(args[0]);
		double finalPosition = Double.parseDouble(args[1]);
		double initialTime = Double.parseDouble(args[2]);
		double finalTime = Double.parseDouble(args[3]);

		double velocity = calculateVelocity(initialPosition, finalPosition, initialTime, finalTime);
		double totalEnergy = calculateTotalEnergy(velocity, initialPosition, finalPosition);
		double displacement = calculateDisplacement(velocity, initialTime, finalTime, totalEnergy);

		displacement = Math.round(displacement * 100) * 1.0 / 100;
		System.out.println(displacement);
	}

	/**
	 * Calculates the velocity of an object based on initial and final positions and
	 * times. If the initial time is equal to the final time, returns 0.0.
	 *
	 * @param initialPosition The initial position of the object.
	 * @param finalPosition   The final position of the object.
	 * @param initialTime     The initial time.
	 * @param finalTime       The final time.
	 * @return The calculated velocity.
	 */
	public static double calculateVelocity(double initialPosition, double finalPosition, double initialTime,
			double finalTime) {
		if (initialTime == finalTime) {
			return 0.0;
		}

		double velocity = (finalPosition - initialPosition) / (finalTime - initialTime);
		return velocity % 100000;
	}

	/**
	 * Calculates the total energy of an object based on velocity, mass, and height.
	 *
	 * @param velocity The velocity of the object.
	 * @param mass     The mass of the object.
	 * @param height   The height of the object.
	 * @return The calculated total energy.
	 */
	public static double calculateTotalEnergy(double velocity, double mass, double height) {
		double gravitationalConstant = 9.81; // Gravitational constant, unit: m/s^2
		double potentialEnergy = mass * gravitationalConstant * height;
		double kineticEnergy = 0.5 * mass * velocity * velocity;
		double totalEnergy = potentialEnergy + kineticEnergy;
		return totalEnergy % 100000;
	}

	/**
	 * Calculates the displacement of an object based on velocity, initial and final
	 * times, and total energy. If the initial time is equal to the final time or
	 * the velocity is 0, returns 0.0.
	 *
	 * @param velocity    The velocity of the object.
	 * @param initialTime The initial time.
	 * @param finalTime   The final time.
	 * @param totalEnergy The total energy of the object.
	 * @return The calculated displacement.
	 */
	public static double calculateDisplacement(double velocity, double initialTime, double finalTime,
			double totalEnergy) {
		if (initialTime == finalTime || velocity == 0) {
			return 0.0;
		}

		double timeInterval = finalTime - initialTime;
		double acceleration = (2 * totalEnergy) / (velocity * timeInterval * timeInterval);
		double displacement = velocity * timeInterval * timeInterval / 2.0 + 0.5 * acceleration;
		return displacement % 100000;
	}
}
