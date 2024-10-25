import java.util.ArrayList;
import java.util.List;

public class MoraiFinder {
    List<Person> personList;

    public MoraiFinder()
    {
        personList=new ArrayList<>();
    }

    public void addDetails(String info)
    {
        String[] details=info.split(", ");
        if(details.length<4)
            return;
        Person person=null;
        Person father=null;
        Person mother=null;
        for(Person human:personList)
        {
            if(details[0].equalsIgnoreCase(human.getName()))
                person=human;
            else if(details[2].equalsIgnoreCase(human.getName()) && human.getGender().equalsIgnoreCase("Male"))
                father=human;
            else if(details[3].equalsIgnoreCase(human.getName()) && human.getGender().equalsIgnoreCase("Female"))
                mother=human;
        }
        if(person==null)
            {
                person=new Person(details[0], details[1]);
                personList.add(person);
            }
        if(father==null)
            {
                father=new Person(details[2],"Male");
                personList.add(father);
            }
        if(mother==null)
            {
                mother=new Person(details[3],"Female");
                personList.add(mother);
            }
        person.setFather(father);
        person.setMother(mother);


    }

    public void findMorai(String personName)
    {
        Person person=null;
        for(Person human:personList)
        {
            if(human.getName().equalsIgnoreCase(personName))
            {
                person=human;
                break;
            }
        }
        if(person==null)
            return;
        List<String> moraiNames=getMoraiList(person);
        System.out.println(moraiNames);
    }

    private List<String> getMoraiList(Person person) {

        List<String> list=new ArrayList<>();
        String personGender=person.getGender();
        String oppositeGender=personGender.equalsIgnoreCase("Male")?"Female":"Male";
        
        //father route
        getMorai(list,person.father,"Female",oppositeGender);
        //mother route
        getMorai(list,person.mother,"Male",oppositeGender);

        return list;

       
        
    }

    private void getMorai( List<String> list, Person parent,String parentSiblingGender,String oppositeGender) {

        for(Person parentSibling:parent.siblings)
        {
            if(parentSibling.getGender().equalsIgnoreCase(parentSiblingGender))
            {
                for(Person parentSiblingChild:parentSibling.children)
                {
                    // System.out.println(parentSiblingChild.getGender()+" "+oppositeGender);
                    if(parentSiblingChild.getGender().equalsIgnoreCase(oppositeGender))
                    {
                        list.add(parentSiblingChild.getName());
                    }
                }
            }
        }
    }
    
}
