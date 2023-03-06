
                if(map.containsKey(arr[head]))
                {
                    for(int index : map.get(arr[head]))
                    {
                        if(index >= 0 && index < arr.length && !visited[index])
                            qu.offer(index);
                    }
                }
                map.remove(arr[head]);
                visited[head] = true;
            }
            level++;
        }
        return -1;
        
    }
}