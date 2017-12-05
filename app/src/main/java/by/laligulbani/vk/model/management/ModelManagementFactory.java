package by.laligulbani.vk.model.management;

public class ModelManagementFactory {

    private static IModelManagement INSTANCE = new ModelManager();

    public static IModelManagement getModelManager() {
        return INSTANCE;
    }
}
