package SymbolicRegression;

import org.jgap.InvalidConfigurationException;
import org.jgap.gp.CommandGene;
import org.jgap.gp.GPFitnessFunction;
import org.jgap.gp.GPProblem;
import org.jgap.gp.IGPProgram;
import org.jgap.gp.function.Add;
import org.jgap.gp.function.Divide;
import org.jgap.gp.function.Multiply;
import org.jgap.gp.function.Subtract;
import org.jgap.gp.impl.DeltaGPFitnessEvaluator;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.GPGenotype;
import org.jgap.gp.terminal.Terminal;
import org.jgap.gp.terminal.Variable;

public class a2Part2 extends GPProblem {
    private static double[] X_INPUTS = {-2.00 , -1.75, -1.50, -1.25, -1.00, -0.75, -0.50, -0.25,
            0.00, 0.25, 0.50, 0.75, 1.00, 1.25, 1.50, 1.75, 2.00, 2.25, 2.50, 2.75};
    private static double[] Y_OUTPUTS = {37.00000, 24.16016, 15.06250, 8.91016, 5.00000,
            2.72266, 1.56250, 1.09766, 1.00000, 1.03516, 1.06250, 1.03516, 1.00000,
            1.09766, 1.56250, 2.72266, 5.00000, 8.91016, 15.06250, 24.16016};
    private Variable xVar;
    public a2Part2() throws InvalidConfigurationException {
        super (new GPConfiguration());
            GPConfiguration config = getGPConfiguration();

            xVar = Variable.create(config, "X", CommandGene.DoubleClass);

            // Set Fitness Evaluator to take inputs as delta values
            // ie. error values, the lower the number, the fitter it is
            config.setGPFitnessEvaluator(new DeltaGPFitnessEvaluator());
            config.setMaxInitDepth(4);
            config.setPopulationSize(1000);
            config.setMaxCrossoverDepth(8); //TODO! I don't know what this is
            config.setFitnessFunction(new SymRegFitnessFunction(X_INPUTS, Y_OUTPUTS, xVar));
            config.setStrictProgramCreation(true);
    }

    @Override
    public GPGenotype create() throws InvalidConfigurationException {
        GPConfiguration config = getGPConfiguration();

        // The return type of the GP program.
        Class[] types = { CommandGene.DoubleClass };

        // Arguments of result-producing chromosome: none
        Class[][] argTypes = {{}};  // Following example code here

        // Define functions and terminals for the tree
        // Note: Lecture notes say use protected divide function,
        // but couldn't find it in this library
        CommandGene[][] nodeSets = {{xVar,
                new Add(config, CommandGene.DoubleClass),
                new Subtract(config, CommandGene.DoubleClass),
                new Multiply(config, CommandGene.DoubleClass),
                new Divide(config, CommandGene.DoubleClass),
                new Terminal(config, CommandGene.DoubleClass, 0.0, 10.0, false)
        }};

        GPGenotype result = GPGenotype.randomInitialGenotype(config, types, argTypes,
                nodeSets, 20, true);
        return result;
    }
    class SymRegFitnessFunction extends GPFitnessFunction {
        private double[] inputs;
        private double[] expected_outputs;
        private Variable xVar;

        private static Object[] NO_ARGS = new Object[0];
        public SymRegFitnessFunction(double[] inputs, double[] expected_outputs, Variable x) {
            this.inputs = inputs;
            this.expected_outputs = expected_outputs;
            this.xVar = x;
        }

        @Override
        protected double evaluate(IGPProgram a_subject) {
            double result = 0;
            for (int i = 0; i < inputs.length; i++) {
                xVar.set(inputs[i]);
                // Execute the genetically engineered algorithm
                double output = a_subject.execute_double(0, NO_ARGS);
                result += Math.abs(output - expected_outputs[i]);
            }
            return result; // Total of all errors, closer to zero, the better
        }
    }
    public static void main(String[] args) throws InvalidConfigurationException {
        GPProblem problem = new a2Part2();

        GPGenotype gp = problem.create();
        gp.setVerboseOutput(true);
        gp.evolve(150);

        gp.outputSolution(gp.getAllTimeBest());
    }
}

