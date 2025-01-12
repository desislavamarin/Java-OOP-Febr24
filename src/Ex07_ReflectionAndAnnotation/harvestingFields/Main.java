package Ex07_ReflectionAndAnnotation.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;
		Field[] declaredFields = richSoilLandClass.getDeclaredFields();

		String line = scanner.nextLine();
		while (!"HARVEST".equals(line)) {
			switch (line) {
				case "all":
					Arrays.stream(declaredFields)
							.forEach(field ->
							System.out.printf("%s %s %s%n",
									Modifier.toString(field.getModifiers()),
									field.getType().getSimpleName(),
									field.getName()));
					break;
				default:
					String finalLine = line;
					Arrays.stream(declaredFields)
							.filter(field -> Modifier.toString(field.getModifiers()).equals(finalLine))
							.forEach(field ->
									System.out.printf("%s %s %s%n",
											Modifier.toString(field.getModifiers()),
											field.getType().getSimpleName(),
											field.getName()));
					break;
			}
			line = scanner.nextLine();
		}
	}
}
