# MarsRover

### How To Use This Application?
1- open this solution in netbeans or intellij then run it.<br>
2- It will show a message:<br>
       *" Hello There, Our Rover Just Landed on Mars,<br>
        Now .. initialize it with its starting coordinates: "*<br>
        
3- It will ask you to enter the starting position (starting coordinate) of the rover and the direction (and all the commands you will use after that will use this point 
as the starting point).<br>
4- It will ask you to choose which mission you want to perform (the number of the part you want to test)
and this menu will repeat itself after each mission until you press **Exit**.<br>

### 1- Mission I ( PartI )
When you choose 1 it will ask you for the path you want to follow, enter it and it will give you the final point after moving through this path<br><br>
## Some examples on Mission 1: (Read the notes at the bottom of the file first)<br>

### Test 1:
Start Point -> (1,2) E<br>
Path -> LFRFFLFFRBB<br>
![P1T1](https://user-images.githubusercontent.com/62244215/180886674-47462805-6dee-4e18-ad7f-eac9cee21279.png)<br>
Result: (1,5) East<br><br><br>


### Test 2:
Start Point -> (2,2) S<br>
Path -> LFRFFLFFRBB<br>
![P1T2](https://user-images.githubusercontent.com/62244215/180886685-427987b4-7bc7-4192-8577-fb537410a104.png)<br>
Result: (5,2) South<br><br>


<br>**The Form Of Input In Mission 1**<br>
![P1 Form](https://user-images.githubusercontent.com/62244215/180887185-8bc38abd-83e8-4956-a654-9c2ca645ae47.png)<br><br><br><br>


### Mission II ( PartII )
When you choose 2 ite will ask you for the path you want to follow and then the number of obstacles then the coordinates for each of them, then it will show you if it will
stop at some point before hitting some obstacle or it will pass without hitting any obstacle.<br><br>
## Some examples on Mission 2: (Read the notes at the bottom of the file first)<br>

### Test 1:
Start Point -> (1,1) E<br>
Path -> LFFRFFFLF<br>
Obstacles -> 1<br>
(2,3)<br>
![P2T1](https://user-images.githubusercontent.com/62244215/180886729-da7463c9-d870-431b-bdff-d6e54bae66c9.png)<br>
Result: (1,3) East STOPPED<br><br>

### Test 2:
Start Point -> (-4,-4) S<br>
Path -> RRFFRFFLF<br>
Obstacles -> 1<br>
(-2,-2)<br>
![P2T2](https://user-images.githubusercontent.com/62244215/180886731-d3e103f3-15ed-424e-9626-0fb1b1e042ee.png)<br>
Result: (-3,-2) East STOPPED<br><br>



**The Form Of Input In Mission 2**<br>
![P2 Form](https://user-images.githubusercontent.com/62244215/180889867-145796e2-0c21-435d-8808-a1a34796b813.png)<br><br><br><br>

### Mission III ( PartIII )
When you choose 3 it will ask you for the ending point and the obstacles then the coordinates for each of them, then it will show you the path between the starting 
point (which you entered in the beginning) and the ending point avoiding all the obstacles.<br><br>
## Some examples on Mission 3: (Read the notes at the bottom of the file first)<br>

### Test 1:
Start Point -> (1,1) E <br>
End Point -> (4,5)<br>
Obstacles -> 4<br>
(1,0)<br>
(1,2)<br>
(2,1)<br>
(0,4)<br>
![P3T1](https://user-images.githubusercontent.com/62244215/180886733-39714fcd-6ad4-43c2-905e-eb817723d6a8.png)<br>
Result: RRFRFFRFFFFLFF<br><br>

### Test 2:
Start Point -> (2,1) S <br>
End Point -> (6,6)<br>
Obstacles -> 6<br>
(3,1)<br>
(2,3)<br>
(4,3)<br>
(3,5)<br>
(5,4)<br>
(5,5)<br>
![P3T2](https://user-images.githubusercontent.com/62244215/180886735-17d925f0-e418-46aa-b15b-48fb2c83bce2.png)
Result: FLFFFFLFFFFFF<br><br>

### Test 3:
Start Point -> (2,1) S <br>
End Point -> (6,6)<br>
Obstacles -> 7<br>
(3,1)<br>
(2,3)<br>
(4,3)<br>
(3,5)<br>
(5,4)<br>
(5,5)<br>
(5,0)<br>
![P3T3](https://user-images.githubusercontent.com/62244215/180886736-c3cf36b2-9fea-4a82-8578-f76b80217ca1.png)
Result: RRFRFFFFLFFFF<br><br>

### Test 4:
Start Point -> (2,1) S <br>
End Point -> (6,6)<br>
Obstacles -> 8<br>
(3,1)<br>
(2,3)<br>
(4,3)<br>
(3,5)<br>
(5,4)<br>
(5,5)<br>
(5,0)<br>
(6,2)<br>
![P3T4](https://user-images.githubusercontent.com/62244215/180886739-19f63bd3-8efe-4568-bd45-146dfcb7e5d3.png)
Result: RFRFFFFFRFFFFF<br><br>

### Test 5:
Start Point -> (-6,2) S <br>
End Point -> (-3,4)<br>
Obstacles -> 6<br>
(-5,0)<br>
(-5,1)<br>
(-5,2)<br>
(-5,3)<br>
(-5,4)<br>
(-3,5)<br>
![P3T5](https://user-images.githubusercontent.com/62244215/180886740-07a4486f-75d9-44fd-894c-03072ab8a824.png)
Result: RRFFFRFFRFLF<br><br>

**The Form Of Input In Mission 3**<br>
![P3 Form](https://user-images.githubusercontent.com/62244215/180891325-f5a51996-2d12-4d6d-b12b-b5357df99750.png)<br><br><br><br>


<br><br>## Notes For Graphs: <br>
  - **Black Circle**: starting point.
  - **Green Arrow Head**: starting direction for this point.
  - **Black Arrow Head**: transition direction (not the final).
  - **Curved Arrows**: changing the direction of the current point.
  - **Dotted Arrow**: Back steps.
  - **Normal Arrow**: Forward steps.
  - **Red (X)**: an obstacle.
  - **Red (X) in a circle**: an obstacle stops the path.
