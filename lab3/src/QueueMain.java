public class QueueMain
{

    public static void main(String[] args)
    {

        PriorityQueue<String> q1 = new PriorityQueue<>(10);

        q1.offer("Name1");
        q1.offer("Name2");
        q1.offer("Name3");
        q1.offer("Name4");
        q1.offer("Name5");

        for (int i = 0; i < 5; i++)
        {
            System.out.print(q1.poll() + " ");
        }
        System.out.println();

        PriorityQueue<Integer> q2 = new PriorityQueue<>(10);

        q2.offer(12);
        q2.offer(2);
        q2.offer(42);
        q2.offer(62);
        q2.offer(12);


        for (int i = 0; i < 5; i++)
        {
            System.out.print(q2.poll() + " ");
        }
        q2.offer(14);
        q2.offer(2);
        q2.offer(42);
        q2.offer(62);
        q2.offer(12);
        q2.swap(0,1);
        System.out.println();
        for (int i = 0; i < 5; i++)
        {
            System.out.print(q2.poll() + " ");
        }
    }

}