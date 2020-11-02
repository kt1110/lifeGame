package model;

public class CellLifeWorld 
{
	private int Row;//��ͼ��
	private int Col;//��ͼ��
	private CellMes[][] cells;
	
	//���캯��
	public CellLifeWorld(int Row,int Col)
	{
		this.Row=Row;
		this.Col=Col;
		cells=new CellMes[Row][Col];
		//��ʼ�����и���
		for(int i=0;i<Row;i++)
			for(int j=0;j<Col;j++)
			{
				cells[i][j]=new CellMes();
			}
	//	randomCellsState();
	}
	
	//��ȡ���糤��
	public int getRow()
	{
		return Row;
	}
	public int getCol()
	{
		return Col;
	}
	
	 //�����ʼ����������
	public void randomCellsState()
	{
		for(int i=0;i<Row;i++)
		{
			for(int j=0;j<Col;j++)
			{
				//����0~9����� ����7ʱ��ϸ������Ϊ��
				int randomNum=(int) (Math.random()*10);
				if(randomNum>7)
					cells[i][j].setState(true);
				else
					cells[i][j].setState(false);	
				//ϸ��״̬����Ϊ���ı�
				cells[i][j].setIsChangeState(false);
			}
		}
	}
	
	//��ȡĳλ����ϸ��״̬  Ĭ�ϱ߽���ȫΪ��ϸ��
	public boolean getCellState(int row,int col)
	{
		if((row<0)||(row>Row-1)||(col<0)||(col>Col-1))
			return false;
		else
		return cells[row][col].getState();
	}
	
	 //�ı�ĳһλ���ϵ�ϸ��״̬
	public boolean changeCellState(int row,int col)
	{
		boolean beforeStatus=cells[row][col].getState();
		cells[row][col].setState(!beforeStatus);
		
		return beforeStatus;
	}
	

	//���øı��־
	public void setChangeFlag(int row,int col)
	{
		cells[row][col].setIsChangeState(true);
	}

	//ȡ���ı��ʶ
	public void cancelChangeFlag(int row,int col)
	{
		cells[row][col].setIsChangeState(false);
	}

	 //��ȡ�ı��ʶ
	public boolean getChangeState(int row,int col)
	{
		return cells[row][col].getIsChangeState();
	}
		
	//��ȡ�ܱ�����ϸ������
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