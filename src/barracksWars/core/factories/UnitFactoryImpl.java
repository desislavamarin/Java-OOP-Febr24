package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException,
			NoSuchMethodException, InvocationTargetException,
			InstantiationException, IllegalAccessException {

		// Archer -> new Archer(); -> за да не ги създаваме чрез switch case
		//не знаем името на пакет -> взимаме името на пакета + типа
		String className = UNITS_PACKAGE_NAME + unitType;

		Class unitClass = Class.forName(className);

		Constructor<Unit> con = unitClass.getDeclaredConstructor();
		//връщаме инстанция
		return con.newInstance();
	}
}
