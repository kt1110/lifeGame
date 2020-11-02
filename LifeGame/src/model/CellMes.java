package model;

public class CellMes 
{
	private boolean State;//细胞状态，false表示死亡，true表示存活
	private boolean IsChangeState;//下一时刻状态是否需要修改
	
	public CellMes()
	{
		State = false;
		IsChangeState = false;//下一时刻状态是否需要修改
	}
	//构造函数
	public CellMes(boolean State,boolean IsChangeState)
	{
		this.State = State;
		this.IsChangeState=IsChangeState;
	}
	//get和set函数
	public boolean getState() {
		return State;
	}
	public void setState(boolean state) {
		State = state;
	}
	public boolean getIsChangeState() {
		return IsChangeState;
	}
	public void setIsChangeState(boolean isChangeState) {
		IsChangeState = isChangeState;
	}
	
	
}
