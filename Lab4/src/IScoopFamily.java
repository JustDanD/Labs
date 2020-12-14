public interface IScoopFamily {
    public void setCurArea( AnimalArea newArea );
    public void feedAnimals();
    public void strokeAnimal();
    public void kissAnimal();
    public boolean askAccess();
    public boolean getIsArmed();
    public boolean getIsProtected();
    public void  setIsProtected( boolean inst );
    public int getBalance();
    public boolean bribe(InternalAffairs trg);
}
