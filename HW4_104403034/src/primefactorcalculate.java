//���3b �P��w 104403034
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class primefactorcalculate {
	public static void main (String[] args) {
		int primeCount=1;
		int stopFlag=0;
		do {
			try {
				String firstString = JOptionPane.showInputDialog(null,"�п�J�@�ӥ����:","���]��",JOptionPane.PLAIN_MESSAGE);
				if (firstString == null) {			//�p�Guser�S��J�ο�ܨ��� 
					JOptionPane.showMessageDialog(null, "nothing~~","bye!!",JOptionPane.PLAIN_MESSAGE);
					stopFlag = 1;
					System.exit(0);
				}
				int firstInt = Integer.parseInt(firstString); //��firststring �ন���
				int positivecheck = Integer.signum(firstInt); //���լO���O����
				if (positivecheck<=0) { 		//�p�G��J�O�t�Ʃ�0
					JOptionPane.showMessageDialog(null, "���~�榡,���s��J","wrong!!",JOptionPane.PLAIN_MESSAGE);
				}else {
					HashSet<Integer>primefac = new HashSet<Integer>();
					primefac = primefactor(firstInt); // �⥦�ǵ�primefactor�p��åB�s��retirning hashset
					
					Set<Integer> primeSorted = new TreeSet<Integer>(primefac); //treeset�⥦�Ƨ�
					Iterator<Integer> primeSet = primeSorted.iterator();
					if (primefac.size()==1) {
						if (firstInt==1) {  //�p�G��J�O1
							JOptionPane.showMessageDialog(null, "1 ���O���","one",JOptionPane.PLAIN_MESSAGE);	
						}else { 		//�p�G��J�u��1�ӽ�ƪ��Ʀr
							JOptionPane.showMessageDialog(null, primeSet.next()+ "is a prime number.","prime number",JOptionPane.PLAIN_MESSAGE);}		
						}else {		//�p�G��J���O�h��@�ӽ�]�ƪ��Ʀr
							while (primeSet.hasNext()) {
								JOptionPane.showMessageDialog(null, primeSet.next() + " is a prime factor of " + firstInt, "Prime factor " + primeCount +" of " + primefac.size(), JOptionPane.PLAIN_MESSAGE);
							primeCount++;
							}		
						}
						primeCount=1;  //���]��1���n�s��J���Ʀr
					}
				}catch(NumberFormatException e) {		//exception:���O��ƪ�
					JOptionPane.showMessageDialog(null, "���~�榡,���s��J","wrong!!",JOptionPane.PLAIN_MESSAGE);
				}
			}while (stopFlag == 0);
		}
		
		public static HashSet<Integer> primefactor (int n){
			HashSet<Integer> primes = new HashSet<Integer>();
			  long copyOfInput = n;
		        if (n == 1){
		        	//��u��1�ӽ�Ʈ�
		        	primes.add(n);
		        } else {
		        	//���u��1�ӽ�Ʈ�,�����åB�p��
		        	for (int i = 2; i <= copyOfInput; i++) {
		        		if (copyOfInput % i == 0) {
		        			primes.add(i); 		//�s�W��]�ƥh HashSet										
		        			copyOfInput /= i;
		        			i--;
		        		}
		        	}
		        }
				return primes;
			}
		}
