public class Main {
    public static void main(String[] args) {
        int k=0;
        int g=3;

        System.out.println("Пошук мінімуму функції за допомогою методу поділу інтервалу навпіл:");
        Task.intervalDivision(k, g);

        System.out.println("Пошук мінімуму функції за допомогою методу випадкового пошуку:");
        Task.randomSearch(k, g);
    }
}
