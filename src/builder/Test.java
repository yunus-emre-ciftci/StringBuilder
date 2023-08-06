package builder;

public class Test {
    /* StringBuilder, metinsel veriler üzerinde değişiklik yapmak için kullanılan ve performansı artıran bir araçtır.
       Normal String sınıfının aksine, StringBuilder nesneleri üzerinde değişiklikler yapılabilir ve yeni veriler eklemek,
       veri silmek, değiştirmek veya birleştirmek gibi işlemler yapmak kolaydır.
       StringBuilder sınıfı, metinsel veriler üzerinde yoğun işlem yapılan durumlarda performansı artırmak için tercih edilir.
       Özellikle büyük metinleri birleştirme veya metin üzerinde tekrarlayan değişiklikler yapma işlemlerinde avantajlıdır.
       */
    private static final String fullName = "John Doe";

    public static void append() {
        StringBuilder stringBuilder = new StringBuilder();

        /*
         * append metodu, metinsel verileri StringBuilder nesnesine nesnesine eklemek için kullanılır.
         * Bu yöntem, mevcut StringBuilder nesnesinin sonuna bir veya daha fazla karakter dizisi ekler.
         *
         * */
        //String ekleme
        stringBuilder.append("Hello");
        //Char ekleme
        stringBuilder.append('A');
        //Integer ekleme
        stringBuilder.append(2312);
        //Double ekleme.
        stringBuilder.append(233.3);
        //boolean ekleme
        stringBuilder.append(true);
        //Bunların yanında long, float veriler de eklenir.

        //Zincirleme kullanım
        stringBuilder.append("Hello").append("Java");
        //stringBuilder nesnesini ekrana yazdırmak için toString kullanırız.
        System.out.println(stringBuilder.toString());
    }

    public static void appendCodePoint() {
        StringBuilder stringBuilder = new StringBuilder();
        //appendCodePoint metodu StringBuilder nesnesine Unicode kod noktasını eklemek için kullanılır.
        stringBuilder.appendCodePoint(0x1F603);

        //Çıktı '😃' bu olacaktır.
        System.out.println(stringBuilder.toString());
    }

    public static class MyStringBuilderDeleteThread implements Runnable {
        //delete metodu StringBuilder nesnesinin içindeki verileri siler.
        @Override
        public void run() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Yunus ").append("Emre").append(" Çiftçi");
            System.out.println(stringBuilder.toString());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //parametre olarak verilen 1.int değer silinecek değerin hangi indeks'ten başlayacağını bildirmek.
            //parametre olarak verilen 2.int değer silinecek değerin hangi indekste biteceğini bildirir.
            stringBuilder.delete(0, stringBuilder.length());
            System.out.println("\nstringBuilder'ın içi silindi. " + stringBuilder.toString());
        }

        public void delete() {
            MyStringBuilderDeleteThread myStringBuilderDeleteThread = new MyStringBuilderDeleteThread();
            Thread thread = new Thread(myStringBuilderDeleteThread);
            thread.start();
        }
    }

    public static void deleteCharAt() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Yunus ").append("Emre").append("Çiftçi").append("learning").append("JAVA");
        System.out.println("Tüm elemanlar: " + stringBuilder.toString());
        //deleteCharAt metodu int indeks no verip o indeksteki karakteri siler.
        stringBuilder.deleteCharAt(0);
        System.out.println("Güncel Tüm Elemanlar: " + stringBuilder.toString());
    }

    public static void replace() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Yunus").append("Emre");
        //replace mevcut StringBuilder nesnesine yeni string eklemek için kullanılır.
        //1. parametre eklemeye hangi indeks'ten başlanacağını bildirir.
        //2. parametre eklemeyi hangi indeks'te bitireceğini bildirir.
        //3. parametre eklenecek String ifadeyi içerir.
        stringBuilder.replace(stringBuilder.length(), stringBuilder.length(), " Çiftçi");
        System.out.println(stringBuilder.toString());
    }

    public static void insert() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Yunus").append("Çiftçi");
        //insert metodu mevcut string'e yeni yazım eklemek için kullanılır.
        stringBuilder.insert(5," Emre ");
        System.out.println(stringBuilder.toString());
    }
}
