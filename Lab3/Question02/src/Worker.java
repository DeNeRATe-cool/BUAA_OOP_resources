/**
 * @Description:
 * @author liuxxxxx
 * @date 2024/8/12 20:03
 */

/**
 * @author: coke_and_ice
 * TODO  
 * 2024/8/12 20:03
 */
public class Worker extends People{
    int my_salary=10;
    public Worker work(){
        System.out.println(getAge()+" "+getName()+" is working.");
        return new Worker();
    }
    public int salary(){
        return my_salary;
    }
    @Override
    // 1
    public void eat() {
        System.out.println("worker "+getAge()+" "+getName()+" is eating.");
    }
}
