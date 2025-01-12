package barracksWars.core.commands;

import barracksWars.interfaces.CommandInterpreter;
import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException,
            IllegalAccessException {
        String className = UNITS_PACKAGE_NAME +
                Character.toUpperCase(commandName.charAt(0)) +
                commandName.substring(1) + "Command";
        Class<Command> commandClazz = (Class<Command>) Class.forName(className);

        Constructor<Command> con = commandClazz.getDeclaredConstructor
                (String[].class, Repository.class, UnitFactory.class);

        return con.newInstance(data, repository, unitFactory);
    }
}
