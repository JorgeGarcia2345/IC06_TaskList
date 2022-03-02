import java.io.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
	// write your code here
        String deadLine, dueDate, name;
        int priority;
        int count =0;
        Task [] toDoTasks = new Task[10];
        Scanner keyboard = new Scanner(System.in);

        File binaryFileTasks = new File("Tasks.dat");

        System.out.println("Previously saved Tasks from binary file");
        if (binaryFileTasks.exists() && binaryFileTasks.length() > 1L)
        {
            try
            {
                ObjectInputStream fileTasksReader = new ObjectInputStream(new FileInputStream(binaryFileTasks));
                toDoTasks = (Task[]) fileTasksReader.readObject();

                while (toDoTasks[count]!=null)
                {
                    System.out.print(count+1 + ": ");
                    System.out.println(toDoTasks[count++]);
                }

            }
            catch (IOException | ClassNotFoundException e)
            {
                System.out.println("Error: " + e.getMessage());
            }

        }
        else
            System.out.println("[None, please enter new Tasks]");
        do
        {
            System.out.print("\nPlease enter the task's name (or \"quit\" to exit): ");
            name = keyboard.nextLine();
            if(name.equalsIgnoreCase("quit")) {break;}
            System.out.print("Please enter due date (in form MM/DD/YYYY): ");
            dueDate = keyboard.nextLine();
            System.out.print("Please enter deadline: ");
            deadLine = keyboard.nextLine();
            System.out.print("Please enter Priority: ");
            priority = keyboard.nextInt();
            keyboard.nextLine();
            toDoTasks [count++] = new Task(name, dueDate, deadLine, priority);

        }
        while (true);

        try
        {
            ObjectOutputStream fileTaskWriter = new ObjectOutputStream(new FileOutputStream(binaryFileTasks));
            fileTaskWriter.writeObject(toDoTasks);
            fileTaskWriter.close();
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
