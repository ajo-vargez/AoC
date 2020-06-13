// This class calculates the fuel requirement for all of the modules on the spacecraft.
class FuelCalculator {

    public static void main(String[] args) {

        // Masses of each modules
        int modulesMassArray[] = {144358, 92044, 53617, 71695, 134329, 149370, 57980, 71899, 58281,
         67662, 81199, 123700, 140080, 63608, 71520, 51020, 125731, 58038, 64709, 120935, 65512,
         142680, 135615, 64251, 131894, 92421, 135197, 118339, 111812, 133283, 100622, 67295,
         125093, 56381, 76811, 82373, 147433, 96033, 114523, 134209, 111383, 130114, 56037, 144439,
         135345, 78408, 98586, 118732, 84373, 62412, 146946, 96024, 101322, 91590, 59401, 113838,
         98867, 76950, 130379, 120006, 66525, 64876, 83451, 114127, 98963, 81096, 110360, 123755,
         77552, 76400, 146026, 70976, 53906, 149079, 121966, 63970, 67562, 62162, 67534, 118706,
         138329, 81170, 101462, 130641, 73241, 86687, 67198, 141550, 117396, 98423, 51743, 88076,
         114089, 118106, 96609, 145837, 61959, 118543, 63914, 54664};

        // Since the 'main' method is static and the findFuelRequiredForEachModule() method is not,
        // you can't call the method without first creating a FuelCalculator object.
        FuelCalculator fuelCalculator = new FuelCalculator();

        System.out.println("The total fuel required for all of the modules on the spacecraft is " 
        + fuelCalculator.findFuelRequiredForEachModule(modulesMassArray));
    }

    // Fuel required to launch a given module is based on its mass. Specifically, to find the fuel
    // required for a module, take its mass, divide by three, round down, and subtract 2.
    private int findFuelRequiredForEachModule(int[] moduleMassArray) {
        int numberOfModules = moduleMassArray.length;
        // Using an array to store these values will increase the memory used by this program.
        int fuelRequiredForEachModule[] = new int[numberOfModules];
        
        for(int i = 0; i < numberOfModules; i++) {
            fuelRequiredForEachModule[i] = (int) Math.ceil(moduleMassArray[i] / 3) - 2;
        }
        return getTotalFuelRequired(fuelRequiredForEachModule);
    }

    // The Fuel Counter-Upper needs to know the total fuel requirement. To find it, individually 
    // calculate the fuel needed for the mass of each module, then add together all the fuel
    // values.
    private int getTotalFuelRequired(int[] fuelForEachModule) {
        // Initialise the sum variable
        int totalFuelRequired = 0;
        for(int i = 0; i < fuelForEachModule.length; i++) {
            totalFuelRequired += fuelForEachModule[i];
        }
        return totalFuelRequired;
    }
}
