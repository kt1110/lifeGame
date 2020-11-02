package model;

public class CellLifeWorld 
{
	private int Row;//地图行
	private int Col;//地图列
	private CellMes[][] cells;
	
	//构造函数
	public CellLifeWorld(int Row,int Col)
	{
		this.Row=Row;
		this.Col=Col;
		cells=new CellMes[Row][Col];
		//初始化所有格子
		for(int i=0;i<Row;i++)
			for(int j=0;j<Col;j++)
			{
				cells[i][j]=new CellMes();
			}
	//	randomCellsState();
	}
	
	//获取世界长宽
	public int getRow()
	{
		return Row;
	}
	public int getCol()
	{
		return Col;
	}
	
	 //随机初始化生命序列
	public void randomCellsState()
	{
		for(int i=0;i<Row;i++)
		{
			for(int j=0;j<Col;j++)
			{
				//生成0~9随机数 大于7时此细胞设置为生
				int randomNum=(int) (Math.random()*10);
				if(randomNum>7)
					cells[i][j].setState(true);
				else
					cells[i][j].setState(false);	
				//细胞状态设置为不改变
				cells[i][j].setIsChangeState(false);
			}
		}
	}
	
	//获取某位置上细胞状态  默认边界外全为死细胞
	public boolean getCellState(int row,int col)
	{
		if((row<0)||(row>Row-1)||(col<0)||(col>Col-1))
			return false;
		else
		return cells[row][col].getState();
	}
	
	 //改变某一位置上的细胞状态
	public boolean changeCellState(int row,int col)
	{
		boolean beforeStatus=cells[row][col].getState();
		cells[row][col].setState(!beforeStatus);
		
		return beforeStatus;
	}
	

	//设置改变标志
	public void setChangeFlag(int row,int col)
	{
		cells[row][col].setIsChangeState(true);
	}

	//取消改变标识
	public void cancelChangeFlag(int row,int col)
	{
		cells[row][col].setIsChangeState(false);
	}

	 //获取改变标识
	public boolean getChangeState(int row,int col)
	{
		return cells[row][col].getIsChangeState();
	}
		
	//获取周边生存细胞数量
	public int getNeiborCellNum(int row,int col)
	{
		int Number=0;
		for(int i=row-1;i<=row+1;i++)
		{
			for(int j=col-1;j<=col+1;j++)
			{
				if((i==row)&&(j==col))
					continue;
				else if(getCellState(i,j))
				{
					Number++;
				}
			}
		}
		return Number;
	}
}