package offer6_tree;

import java.util.Arrays;
import java.util.Stack;

public class Tree_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int fornt[] = {1,2,4,7,3,5,6,8};
		int midle[] = {4,7,2,1,5,3,8,6};
		//构建树
		Node_tree tree = getTree(fornt,midle);
		
		System.out.println("递归先序遍历: ");
		outFTree(tree);
		System.out.println();
		System.out.println("循环先序遍历: ");
		outFTree_F(tree);
		outFTree_F2(tree);
		
		System.out.println("递归中序遍历: ");
		outMTree(tree);
		System.out.println();
		
		/*System.out.println("循环先序遍历: ");
		outMTree_F(tree);*/
		
		System.out.println("递归后序遍历: ");
		outBTree(tree);
		/*System.out.println("循环后序遍历: ");
		outBTree_F(tree);*/
		
	}
	
	
	public static Node_tree getTree(int F[],int M[]){
		
		Node_tree jjp =  new Node_tree();
		jjp.value = F[0];
		
		int i=0;
		for(;i<F.length;i++){
			if(M[i]==F[0]){
				break;
			}
		}
		
		if(i+1!=F.length){
			int rf[] = Arrays.copyOfRange(F, i+1, F.length);
			int rm[] = Arrays.copyOfRange(M, i+1, M.length);
			jjp.pRight = getTree(rf,rm);
		}
		
		if(i!=0){
			int lf[] = Arrays.copyOfRange(F, 1,i+1);
			int lm[] = Arrays.copyOfRange(M, 0,i);
			jjp.pLeft = getTree(lf,lm);
		}
		
		return jjp;
	}
	
	//先序递归遍历
	public static void outFTree(Node_tree jjp){
		
		System.out.print(jjp.value+" ");
		
		if(jjp.pLeft!=null){
			outFTree(jjp.pLeft);
		}
		
		if(jjp.pRight!=null){
			outFTree(jjp.pRight);
		}
		
	}
	
	//中序递归遍历
	public static void outMTree(Node_tree jjp){
		
		if(jjp.pLeft!=null){
			outMTree(jjp.pLeft);
		}
		
		System.out.print(jjp.value+" ");
		
		if(jjp.pRight!=null){
			outMTree(jjp.pRight);
		}
		
	}
	
	//后续递归遍历
	public static void outBTree(Node_tree jjp){
		
		if(jjp.pLeft!=null){
			outBTree(jjp.pLeft);
		}
		
		if(jjp.pRight!=null){
			outBTree(jjp.pRight);
		}
		
		System.out.print(jjp.value+" ");
	}
	
	//非递归先序遍历
	public static void outFTree_F(Node_tree tree){
		
		Node_tree l = tree;
		
		while(l.pRight!=null){
			if(l.pLeft!=null){
				Node_tree L = l.pLeft;
				while(L.pRight!=null){
					L = L.pRight;
				}
				
				L.pRight = l.pRight;
				l.pRight = null;
				
			}
			
			if(l.pLeft==null){
				l.pLeft = l.pRight;
				l.pRight = null;
			}
			l = l.pLeft;
		}
		
		while(tree.pLeft!=null){
			System.out.print(tree.value+" ");
			tree = tree.pLeft;
		}
		
		System.out.println(tree.value+" ");
		System.out.println();
	}
	
	//使用栈实现先序遍历
	
	public static void outFTree_F2(Node_tree tree){
		System.out.println("用栈实现遍历：");
		Node_tree figer = tree;
		Node_tree bot = new Node_tree();
		bot.value = -1;
		Stack stac = new Stack();
		stac.push(bot);
		bot = (Node_tree)stac.peek();
		do{
			Node_tree T = figer;
			
			if(figer == (Node_tree)stac.peek()){
				if(figer.pRight!=null){
					figer = figer.pRight;
					stac.push(T);
				}else{
					stac.pop();
					figer =(Node_tree)stac.peek();
				}
			}else{
				System.out.print(figer.value+" ");
				if(figer.pLeft!=null){
					figer = figer.pLeft;
					stac.push(T);
				}else{
					if(figer.pRight!=null){
						figer = figer.pRight;
						stac.push(T);
					}else{
						stac.pop();
						figer =(Node_tree)stac.peek();
					}
				}
			}
		}
		while(!((Node_tree)stac.peek()==bot));
		System.out.println();
	}
}






























