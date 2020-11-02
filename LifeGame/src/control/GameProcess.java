package control;

import model.CellLifeWorld;

public class GameProcess 
{
	protected CellLifeWorld world;
	//Ĭ�Ϲ��캯��
	public GameProcess()
	{
		world=new CellLifeWorld(10,10);
	}
	//���캯��
	public GameProcess(int row,int col)
	{
		world=new CellLifeWorld(row,col);
	}
	
	//���ܹ���
	public void cellMultiply()
	{
		//ϸ����һ״̬�ж�
		for(int i=0;i<world.getRow();i++)
		{
			for(int j=0;j<world.getCol();j++)
			{
				//��ȡ�ܱ�ϸ������
				int cellNum=world.getNeiborCellNum(i, j);
				//�ж���һ�׶�ϸ��״̬
				if(world.getCellState(i, j)!=cellSavePrinciple(world.getCellState(i, j),cellNum))
				{
					world.setChangeFlag(i, j);
				}				
			}
		}
		//ϸ��״̬�ı�
		for(int i=0;i<world.getRow();i++)
		{
			for(int j=0;j<world.getCol();j++)
			{
				if(world.getChangeState(i, j))
				{
					world.changeCellState(i, j);
					//�ı�ϸ��״̬֮��ı��ʶ����
					world.cancelChangeFlag(i, j);
				}
			}
		}
	}
	
	//��Ϸ����
	private boolean cellSavePrinciple(boolean curState,int surCellNumber)
	{
		if(surCellNumber==3)
		{
			return true;
		}
		else if(surCellNumber==2)
		{
			return curState;
		}
		else
		{
			return false;
		}
	}
	
	//�޸�ĳһλ��ϸ��״̬ ������ԭ״̬
	public boolean changeCellState(int row,int col)
	{
		return world.changeCellState(row, col);
	}
	
	 //����ϸ����ʼ״̬Ϊ���
	public void setDefaultWorld()
	{
		world.randomCellsState();
	}
	
	//����ϸ���������Ķ�ά����
	public int[][] getAllCellState()
	{
		int width=world.getRow();
		int length=world.getCol();
		
		int[][] cellmap=new int[width][length];
		
		for(int i=0;i<width;i++)
		{
			for(int j=0;j<length;j++)
			{
				if(world.getCellState(i, j))
				{
					cellmap[i][j]=1;
				}
				else
				{
					cellmap[i][j]=0;
				}
			}
		}
		return cellmap;
	}

}
