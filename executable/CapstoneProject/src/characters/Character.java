package characters;

public abstract class Character
{
	private double health;
	private double damage;
	private int attackPow;
	private int defensePow;
	
	public Character(double health, double damage, int defensePow, int attackPow)
	{
		this.health = health;
		this.attackPow = attackPow;
		this.defensePow = defensePow;
		this.damage = damage;
	}
	
	public void doDamage() {
		
	}
	 public double getHealth()
	 {
		 return health;
	 }
	 public double getDamage()
	 {
		 return health;
	 }
	public int getAttackPow() {
		return attackPow;
	}
	public int getDefensePow() {
		return defensePow;
	}
	
	public void moveX(int moveBy)
	{
		
	}
	
	public void moveY(int moveBy)
	{
		
	}
	
}