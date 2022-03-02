import java.io.Serializable;
import java.util.Objects;

public class Task implements Serializable
{
    private String mDeadLine;
    private String mDueDate;
    private String mName;
    private int mPriority;

    public Task(String mDeadLine, String mDueDate, String mName, int mPriority) {
        this.mDeadLine = mDeadLine;
        this.mDueDate = mDueDate;
        this.mName = mName;
        this.mPriority = mPriority;
    }

    public String getmDeadLine() {
        return mDeadLine;
    }

    public void setmDeadLine(String mDeadLine) {
        this.mDeadLine = mDeadLine;
    }

    public String getmDueDate() {
        return mDueDate;
    }

    public void setmDueDate(String mDueDate) {
        this.mDueDate = mDueDate;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmPriority() {
        return mPriority;
    }

    public void setmPriority(int mPriority) {
        this.mPriority = mPriority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return mPriority == task.mPriority && Objects.equals(mDeadLine, task.mDeadLine) && Objects.equals(mDueDate, task.mDueDate) && Objects.equals(mName, task.mName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mDeadLine, mDueDate, mName, mPriority);
    }

    @Override
    public String toString()
    {
        String level = "";
        switch (mPriority)
        {
            case 1:
                level ="High";
                break;
            case 2:
                level = "Medium";
                break;
            case 3:
                level = "Low";
                break;
        }
        return "Task [" +
                "name=" + mName +
                ", dueDate=" + mDueDate +
                ", deadLine=" + mDeadLine +
                ", priority=" + level +
                ']';
    }
}
