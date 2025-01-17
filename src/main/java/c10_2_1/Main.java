package c10_2_1;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class Main {
    private long window;

    public void run() {
        System.out.println("Запуск LWJGL...");
        init();
        loop();
        cleanup();
    }

    private void init() {
        // Инициализация GLFW
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Не удалось инициализировать GLFW");
        }

        // Создание окна
        window = GLFW.glfwCreateWindow(800, 600, "LWJGL Example", 0, 0);
        if (window == 0) {
            throw new RuntimeException("Не удалось создать окно");
        }

        // Установка текущего контекста
        GLFW.glfwMakeContextCurrent(window);

        // Включение V-Sync
        GLFW.glfwSwapInterval(1);

        // Инициализация OpenGL
        //
        GL.createCapabilities();
    }

    private void loop() {
        // Основной цикл
        while (!GLFW.glfwWindowShouldClose(window)) {
            // Установка цвета экрана (RGBA)
            GL11.glClearColor(0.1f, 0.2f, 0.3f, 1.0f);
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

            // Рисуем треугольник
            GL11.glBegin(GL11.GL_TRIANGLES);
            GL11.glColor3f(1.0f, 0.0f, 0.0f); // Красный
            GL11.glVertex2f(-0.5f, -0.5f);
            GL11.glColor3f(0.0f, 1.0f, 0.0f); // Зелёный
            GL11.glVertex2f(0.5f, -0.5f);
            GL11.glColor3f(0.0f, 0.0f, 1.0f); // Синий
            GL11.glVertex2f(0.0f, 0.5f);
            GL11.glEnd();

            // Обновление окна
            GLFW.glfwSwapBuffers(window);

            // Обработка событий
            GLFW.glfwPollEvents();
        }
    }

    private void cleanup() {
        // Уничтожение окна и завершение работы GLFW
        GLFW.glfwDestroyWindow(window);
        GLFW.glfwTerminate();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
