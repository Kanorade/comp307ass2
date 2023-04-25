package SymbolicRegression;

import org.jgap.InvalidConfigurationException;
import org.jgap.gp.GPProblem;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.GPGenotype;

public class SymReg extends GPProblem {
    public SymReg() throws InvalidConfigurationException {
        super (new GPConfiguration());

    }

    @Override
    public GPGenotype create() throws InvalidConfigurationException {
        return null;
    }

    public static void main(String[] args) throws InvalidConfigurationException {
        GPProblem problem = new SymReg();

    }
}
