import java.util.ArrayList;
import java.util.List;

/**
 * Person
 */
public class Person {

    private String name;
    private String gender;

    Person father;
    Person mother;

    List<Person> siblings;
    List<Person> children;

    public Person(String name,String gender)
    {
        this.name=name;
        this.gender=gender;
        children=new ArrayList<>();
        siblings=new ArrayList<>();
    }

    public void setFather(Person father)
    {
        for(Person child:father.children)
        {
            if(!child.siblings.contains(this))
                child.siblings.add(this);
            if(!this.siblings.contains(child))
                this.siblings.add(child);
        }

        father.children.add(this);
        this.father=father;
        

    }
    public void setMother(Person mother)
    {
        for(Person child:mother.children)
        {
            if(!child.siblings.contains(this))
                child.siblings.add(this);
            if(!this.siblings.contains(child))
                this.siblings.add(child);
        }
        mother.children.add(this);
        this.mother=mother;
    
    }

    public String getName()
    {
        return this.name;
    }
    public String getGender()
    {
        return this.gender;
    }



    

    

    
}