package physicsEngine;

public class PhysicsEngine {

	public static void main(String[] args) {
		// 输入参数含义和建议范围：
		// args[0]: initialPosition - 初始位置（单位：米）, 建议范围: 任何实数
		// args[1]: finalPosition - 末位置（单位：米）, 建议范围: 任何实数
		// args[2]: initialTime - 初始时间（单位：秒）, 建议范围: 任何实数
		// args[3]: finalTime - 末时间（单位：秒）, 建议范围: 任何实数

		if (args.length != 4) {
			System.err.println("请输入四个参数：initialPosition, finalPosition, initialTime, finalTime");
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

	public static double calculateVelocity(double initialPosition, double finalPosition, double initialTime,
			double finalTime) {
		if (initialTime == finalTime) {
			return 0.0;
		}

		double velocity = (finalPosition - initialPosition) / (finalTime - initialTime);
		return velocity % 100000;
	}

	public static double calculateTotalEnergy(double velocity, double mass, double height) {
		double gravitationalConstant = 9.81; // 重力常数，单位 m/s^2
		double potentialEnergy = mass * gravitationalConstant * height;
		double kineticEnergy = 0.5 * mass * velocity * velocity;
		double totalEnergy = potentialEnergy + kineticEnergy;
		return totalEnergy % 100000;
	}

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
