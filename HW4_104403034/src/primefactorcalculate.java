//資管3b 周芷安 104403034
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
				String firstString = JOptionPane.showInputDialog(null,"請輸入一個正整數:","找質因數",JOptionPane.PLAIN_MESSAGE);
				if (firstString == null) {			//如果user沒輸入或選擇取消 
					JOptionPane.showMessageDialog(null, "nothing~~","bye!!",JOptionPane.PLAIN_MESSAGE);
					stopFlag = 1;
					System.exit(0);
				}
				int firstInt = Integer.parseInt(firstString); //把firststring 轉成整數
				int positivecheck = Integer.signum(firstInt); //測試是不是正數
				if (positivecheck<=0) { 		//如果輸入是負數或0
					JOptionPane.showMessageDialog(null, "錯誤格式,重新輸入","wrong!!",JOptionPane.PLAIN_MESSAGE);
				}else {
					HashSet<Integer>primefac = new HashSet<Integer>();
					primefac = primefactor(firstInt); // 把它傳給primefactor計算並且存取retirning hashset
					
					Set<Integer> primeSorted = new TreeSet<Integer>(primefac); //treeset把它排序
					Iterator<Integer> primeSet = primeSorted.iterator();
					if (primefac.size()==1) {
						if (firstInt==1) {  //如果輸入是1
							JOptionPane.showMessageDialog(null, "1 不是質數","one",JOptionPane.PLAIN_MESSAGE);	
						}else { 		//如果輸入只有1個質數的數字
							JOptionPane.showMessageDialog(null, primeSet.next()+ "is a prime number.","prime number",JOptionPane.PLAIN_MESSAGE);}		
						}else {		//如果輸入的是多於一個質因數的數字
							while (primeSet.hasNext()) {
								JOptionPane.showMessageDialog(null, primeSet.next() + " is a prime factor of " + firstInt, "Prime factor " + primeCount +" of " + primefac.size(), JOptionPane.PLAIN_MESSAGE);
							primeCount++;
							}		
						}
						primeCount=1;  //重設為1給要新輸入的數字
					}
				}catch(NumberFormatException e) {		//exception:不是整數的
					JOptionPane.showMessageDialog(null, "錯誤格式,重新輸入","wrong!!",JOptionPane.PLAIN_MESSAGE);
				}
			}while (stopFlag == 0);
		}
		
		public static HashSet<Integer> primefactor (int n){
			HashSet<Integer> primes = new HashSet<Integer>();
			  long copyOfInput = n;
		        if (n == 1){
		        	//當只有1個質數時
		        	primes.add(n);
		        } else {
		        	//當不只有1個質數時,全拿並且計數
		        	for (int i = 2; i <= copyOfInput; i++) {
		        		if (copyOfInput % i == 0) {
		        			primes.add(i); 		//新增質因數去 HashSet										
		        			copyOfInput /= i;
		        			i--;
		        		}
		        	}
		        }
				return primes;
			}
		}
