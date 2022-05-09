Index:
- General Notes
- Sum of Elements
- Max Elements
- Height of Tree
- Check if Value Exists in Tree
- Reverse
- DFS Path, Remembering the Path Taken
- Bottom Up Traversal, get the kth Ancestor
- Lowest Common Ancestor
- Breadth-First-Search (Using Queue)

General Notes:
1. Finding one or more base cases
2. Calling the same function on the left subtree
3. Calling the same function on the right subtree
4. Joining the results


- Sum of Elements:

def treeSum(root):
    if root is None:
        return 0
    else:
        leftSum = treeSum(root.left)
        rightSum = treeSum(root.right)
        return root.data + leftSum + rightSum


- Max Elements:

def treeMax(root):
    if root is None:
        return float("-inf")
    else:
        leftMax = treeMax(root.left)
        rightMax = treeMax(root.right)
        return max(root.data, leftMax, rightMax)


- Height of Tree:

    public static int getHeight(TreeNode root){
        if(root == null)
            return -1;  // Return -1 because you are adding 1 at the end

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }


- Check if Value Exists in Tree:

def existsInTree(root,value):
    if root is None:
        return False
    else:
        inLeft = existsInTree(root.left, value)
        inRight = existsInTree(root.right, value)
        return root.data == value or inLeft or inRight


- Reverse 

def reverseTree(root):
    if root is None:
        return
    else:
        reverseTree(root.left)
        reverseTree(root.right)
        root.left, root.right = root.right, root.left


- DFS Path, Remembering the Path Taken:

def get_path_fromt_root(root, val):
def dfs(root, path): // Parameter Path
    if root is None:
        return
    else:
        print(root.val)
        path.append(root) // Add Node

        if(root.val == val)
            or dfs(root.left, path)
            or dfs(root.right, path)
                return True
        path.pop() // Remove Node
        return False

path = []
dfs(root,val,path)
return path

- Bottom Up Traversal, get the kth Ancestor:
def kth_ancestor(root, val, k):
    path = get_path_from_root(root, val)
    if k >= len(path):
        return None
    else:
        return path[len(path)-k-1]


- Lowest Common Ancestor:
def lca(root, val1, val2):
    path1 = get_path_from_root(root,val1)
    path2 = get_path_from_root(root,val2)
    last_common = None
    i = j = 0
    while (i < len(path1) and j < len(path2)):
        if path1[i] == path2[j]:
            last_common = path1[i]
            i += 1
            j += 1
        else:
            break
    return last_common


- Breadth-First-Search (Using Queue)
    1. Look at root
    2. Add both left and right children to Queue
    3. Take out from Queue
    4. Add children of Node taken out of Queue to the Queue

void bfs:
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    while(!queue.isEmpty()){
        Node tempNode = queue.poll() // Remove head
        print(tempNode.data)

        if(tempNode.left != null)
            queue.add(tempNode.left)

        if (tempNode.right != null)
            queue.add(tempNode.right)
    }