package java17;

sealed class Parent permits Child1, Child2, Child3{
    public void pint(){
        System.out.println("Parent");
    }
}
// Selaed class child class must be sealed, non-seald, or final

 non-sealed class Child1 extends Parent{
    @Override
    public void pint(){
        System.out.println("Child1");
    }

}

final class Child2 extends Parent{

    @Override
    public void pint(){
        System.out.println("Child2");
    }

}

sealed class Child3  extends  Parent{
    @Override
    public void pint(){
        System.out.println("Child3");
    }
}

non-sealed class Child4 extends Child3{
    @Override
    public void pint(){
        System.out.println("Child4");
    }
}

// Sealed class must have children
sealed class Child5 permits Child6{

}

non-sealed class Child6 extends Child5{
    public void pint(){
        System.out.println("Child4");
    }
}

public class SealedClass {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.pint();
        parent = new Child1();
        parent.pint();
        parent = new Child2();
        parent.pint();
        parent = new Child3();
        parent.pint();
        parent = new Child4();
        parent.pint();
    }
}
