# PhysicsEngine
A physics engine that simulates the movement of objects in the vertical direction and calculates their associated physics parameters

这段程序是一个物理引擎，用于模拟物体在垂直方向上的运动，并计算其相关物理参数。以下是程序的主要功能：

1. **输入参数：** 从命令行接收四个双精度值，分别表示物体的初始位置（`initialPosition`）、末位置（`finalPosition`）、初始时间（`initialTime`）和末时间（`finalTime`）。

2. **计算速度（calculateVelocity）：** 根据给定的初始和末位置、初始和末时间计算物体的速度。如果初始时间等于末时间，返回速度为0.0。速度的计算基于以下公式：\[ \text{velocity} = \frac{\text{finalPosition} - \text{initialPosition}}{\text{finalTime} - \text{initialTime}} \]

3. **计算总能量（calculateTotalEnergy）：** 根据给定的速度、物体质量和高度计算物体的总能量。总能量的计算包括势能和动能，分别由以下公式给出：
   \[ \text{potentialEnergy} = \text{mass} \cdot \text{gravitationalConstant} \cdot \text{height} \]
   \[ \text{kineticEnergy} = 0.5 \cdot \text{mass} \cdot \text{velocity}^2 \]
   总能量为势能和动能之和。

4. **计算位移（calculateDisplacement）：** 根据给定的速度、初始和末时间以及总能量计算物体的位移。如果初始时间等于末时间或速度为0，返回位移为0.0。位移的计算基于以下公式：
   \[ \text{displacement} = \text{velocity} \cdot \text{timeInterval}^2 / 2 + 0.5 \cdot \text{acceleration} \]

5. **输出结果：** 将计算得到的位移进行舍入处理，并输出到控制台。

总体而言，这个物理引擎模拟了垂直方向上物体的运动，并提供了计算速度、总能量和位移的功能。
