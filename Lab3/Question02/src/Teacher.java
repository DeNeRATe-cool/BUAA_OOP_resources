/**
 * @Description:
 * @author liuxxxxx
 * @date 2024/8/12 20:01
 */

/**
 * @author: coke_and_ice
 * TODO  
 * 2024/8/12 20:01
 */
public class Teacher extends Worker{
    long my_salary=100;
    public void teach(){
        System.out.println(getAge()+" "+getName()+" is teaching.");
    }
    @Override
    // 2
    public Worker work(){
        System.out.println(getAge()+" "+getName()+" is working.");
        return new Worker();
    }
    @Override
    // 3
    public int salary(){
        return (int)my_salary;
    }
}
