package control;

import model.CellLifeWorld;

public class GameProcess 
{
	protected CellLifeWorld world;
	//默认构造函数
	public GameProcess()
	{
		world=new CellLifeWorld(10,10);
	}
	//构造函数
	public GameProcess(int row,int col)
	{
		world=new CellLifeWorld(row,col);
	}
	
	//繁衍过程
	public void cellMultiply()
	{
		//细胞下一状态判断
		for(int i=0;i<world.getRow();i++)
		{
			for(int j=0;j<world.getCol();j++)
			{
				//获取周边细胞数量
				int cellNum=world.getNeiborCellNum(i, j);
				//判断下一阶段细胞状态
				if(world.getCellState(i, j)!=cellSavePrinciple(world.getCellState(i, j),cellNum))
				{
					world.setChangeFlag(i, j);
				}				
			}
		}
		//细胞状态改变
		for(int i=0;i<world.getRow();i++)
		{
			for(int j=0;j<world.getCol();j++)
			{
				if(world.getChangeState(i, j))
				{
					world.changeCellState(i, j);
					//改变细胞状态之后改变标识重置
					world.cancelChangeFlag(i, j);
				}
			}
		}
	}
	
	//游戏规则
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
	
	//修改某一位置细胞状态 并返回原状态
	public boolean changeCellState(int row,int col)
	{
		return world.changeCellState(row, col);
	}
	
	 //设置细胞初始状态为随机
	public void setDefaultWorld()
	{
		world.randomCellsState();
	}
	
	//返回细胞生存矩阵的二维数组
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
