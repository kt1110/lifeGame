package model;

public class CellMes 
{
	private boolean State;//ϸ��״̬��false��ʾ������true��ʾ���
	private boolean IsChangeState;//��һʱ��״̬�Ƿ���Ҫ�޸�
	
	public CellMes()
	{
		State = false;
		IsChangeState = false;//��һʱ��״̬�Ƿ���Ҫ�޸�
	}
	//���캯��
	public CellMes(boolean State,boolean IsChangeState)
	{
		this.State = State;
		this.IsChangeState=IsChangeState;
	}
	//get��set����
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
