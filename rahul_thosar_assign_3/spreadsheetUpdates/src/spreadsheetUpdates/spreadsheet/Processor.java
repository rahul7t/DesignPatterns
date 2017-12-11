package spreadsheetUpdates.spreadsheet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import spreadsheetUpdates.observer.Cell;
import spreadsheetUpdates.util.FileProcessor;
import spreadsheetUpdates.util.Logger;

public class Processor {

	List<Cell> subjectList = new ArrayList<Cell>();
	List<String> CycleList = new ArrayList<String>();
	int sum = 0;
	
	/**
	 * Method to line read
	 * @param inputFile
	 */
	public void lineRead(String inputFile) {
		Logger.writeMessage("Processor lineRead method called", Logger.DebugLevel.IN_RUN);
		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(inputFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("File not found: " + inputFile + "Please check name");
			e.printStackTrace();
			System.exit(1);
		}finally{
			
		}
		br = new BufferedReader(fr);
		FileProcessor fp = new FileProcessor(br);
		String line;
		line = fp.readLineFromFile();
		if (line == null) {
			System.err.println("File empty: " + inputFile + ". Please check");
			System.exit(1);
		}
		if(line.trim().isEmpty()){
			System.err.println("Empty line in file(possiblly new line character): " + inputFile + ". Please check");
			System.exit(1);
		}
		do {

			//System.out.println(line);
			processLine(line);

		} while ((line = fp.readLineFromFile()) != null);
		calculateSum();
	}

	/**
	 * Method to calculate sum of cells
	 */
	private void calculateSum() {
		// TODO Auto-generated method stub
		Logger.writeMessage("In Results calculateSum", Logger.DebugLevel.FROM_RESULTS);
		int tempSum=0;
		for(Cell cells : subjectList){
			tempSum = tempSum + cells.getValue();
		}
		sum=tempSum;
		String text = "\nThe sum of all cell values is: "+sum;
//		System.out.println("sum: "+sum);
		for(String cycles : CycleList){
			Logger.writeMessage(cycles, Logger.DebugLevel.FROM_RESULTS);
		}
		Logger.writeMessage(text, Logger.DebugLevel.FROM_RESULTS);
		
		
	}

	
	/**
	 * Method to check if passed param is numeric
	 * @param s
	 * @return
	 */
	public boolean isNumeric(String s) {
		return s.matches("[-+]?\\d*\\.?\\d+");
	}

	/**
	 * Method to process line
	 * @param line
	 */
	public void processLine(String line) {
		String tokens[] = line.split("=");
		if(tokens.length!=2){
			System.err.println("Line from file '"+line+"' is not of cell = op1 + op2 format");
			System.exit(1);
		}
		String LHS = tokens[0];
		System.err.println();
		String RHS[] = tokens[1].split("\\+");
		if(RHS.length!=2){
			System.err.println(line+" is not of cell = op1 + op2 format");
			System.exit(1);
		}
		Cell cellObj = new Cell();
		boolean existsInSubj = false;
		boolean cycleDetected = false;

//		System.out.println(LHS + " " + RHS[0] + " " + RHS[1]);
		for (Cell cellcheck : subjectList) {// check if already in subj list
//			System.out.println("Cycle check! RHS[0]" + RHS[0] + " " + cellcheck.getCellName());
			if (LHS.equalsIgnoreCase(cellcheck.getCellName())) {
//				System.out.println("matched!");
				for (Cell checkObserver : cellcheck.getObserverList()) {
//					System.out.println(" LHS match " + LHS + " " + checkObserver.getCellName());
					if (RHS[0].equalsIgnoreCase(checkObserver.getCellName())) {
//						System.out.println("Cycle detected!");
						Logger.writeMessage("Cycle detected!", Logger.DebugLevel.FROM_RESULTS);
						cycleDetected = true;
					}
					if (RHS[1].equalsIgnoreCase(checkObserver.getCellName())) {
//						System.out.println("Cycle detected!");
						Logger.writeMessage("Cycle detected!", Logger.DebugLevel.FROM_RESULTS);
						cycleDetected = true;
					}
				}

			}
		}
		if (cycleDetected != true) {
			for (Cell cells : subjectList) {// check if already in subj list
				if (LHS.equalsIgnoreCase(cells.getCellName())) {
//					System.out.println(LHS + " already in subj list");
					cellObj = cells;
					// logic for removal
//					if(cells.getOperand1()!=null){
					if (!isNumeric(cells.getOperand1())) {
						for (Cell cellSubj : subjectList) {
							if (cells.getOperand1().equalsIgnoreCase(cellSubj.getCellName())) {
								cellSubj.removeObserver(cells);	
							}
						}
					}
//				}
//					if(cells.getOperand2()!=null){
					if (!isNumeric(cells.getOperand2())) {
						for (Cell cellSubj : subjectList) {
							if (cells.getOperand2().equalsIgnoreCase(cellSubj.getCellName())) {
								cellSubj.removeObserver(cells);	
							}
						}
					}
//					}
					
					// end removal logic
					existsInSubj = true;
				}
			}
			if (existsInSubj == false) {

				cellObj.setCellName(LHS);
				cellObj.setOperand1(RHS[0]);
				cellObj.setOperand2(RHS[1]);
				subjectList.add(cellObj);
				Logger.writeMessage("subjectList edited", Logger.DebugLevel.IN_RESULTS);
			}
			cellObj.setOperand1(RHS[0]);
			cellObj.setOperand2(RHS[1]);
			if (isNumeric(RHS[0]) && (isNumeric(RHS[1]))) { // both numeric
//				System.out.println(RHS[0] + "is numeric" + RHS[1] + "is numeric");
				// both are literals
				cellObj.setValue(Integer.parseInt(RHS[0]) + Integer.parseInt(RHS[1]));
				cellObj.notifyObserver();
				cellObj.setLitFlag(true);
				cellObj.setOperand1("lit");
				cellObj.setOperand2("lit");
				cellObj.setOperand1Val(Integer.parseInt(RHS[0]));
				cellObj.setOperand2Val(Integer.parseInt(RHS[1]));

				// subjectList.add(cellObj);
//				System.out.println("Added " + line + " to subj list");
//				System.out.println("exiting if");
			}

			// if only 1 is numeric
			else {
//				System.out.println("Entering else");
				if (!isNumeric(RHS[0])) {
					boolean rhsInSubjList = false;
//					System.out.println("Entering first else RHS[0]" + RHS[0]);
					for (Cell cells : subjectList) {// check if already in subj
													// list
						if (RHS[0].equalsIgnoreCase(cells.getCellName())) {
							rhsInSubjList = true;
							if(cells.getLitFlag()){
								cellObj.setOperand1Val(cells.getValue());
							}
							
//							System.out.println("rahul" + cells);
//							System.out.println(cellObj);
							
							cells.registerObserver(cellObj);
							Logger.writeMessage("subjectList edited", Logger.DebugLevel.IN_RESULTS);
//							System.out.println(cells);
						}
					}
					// if RHS[0] is not in subject list, add it as subject
					
					if(rhsInSubjList!=true){
						Cell TempRHSCell = new Cell();
						TempRHSCell.setCellName(RHS[0]);
						TempRHSCell.registerObserver(cellObj);
						subjectList.add(TempRHSCell);
					}
					//if(!subjectList.contains(cellObj.getCellName()) ){
					//
//					boolean presentInReg=false;
//					for (Cell cells : subjectList) {
//						if(cells.getCellName()==RHS[0]){
//						presentInReg = true;
//				}
//				}
//					if(presentInReg!=true){
//						Cell tempCell =  new Cell();
//						tempCell.setCellName(RHS[0]);
//						subjectList.add(tempCell);
//					}
					//
						
					
				}
				else{
					//RHS[0] is literal, so update it
					cellObj.setOperand1Val(Integer.parseInt(RHS[0]));
					cellObj.setOperand1("lit");
				}
				if (!isNumeric(RHS[1])) {
//					System.out.println("Entering second else RHS[1]" + RHS[1]);
					boolean rhs1InSubjList = false;
					for (Cell cells : subjectList) {
						if (RHS[1].equalsIgnoreCase(cells.getCellName())) {
							rhs1InSubjList = true;
							if(cells.getLitFlag()){
								cellObj.setOperand2Val(cells.getValue());
							}
//							System.out.println("rahul2" + cells);
							// int idx = subjectList.indexOf(cells);
//							System.out.println(cellObj);
							cells.registerObserver(cellObj);
							Logger.writeMessage("subjectList edited", Logger.DebugLevel.IN_RESULTS);
//							System.out.println(cells);
							// subjectList.add(cellObj);
						}
					}
					
					// if RHS[1] is not in subject list, add it as subject
					if(rhs1InSubjList!=true){
						Cell TempRHS1Cell = new Cell();
						TempRHS1Cell.setCellName(RHS[1]);
						TempRHS1Cell.registerObserver(cellObj);
						subjectList.add(TempRHS1Cell);
					}
//					if(!subjectList.contains(RHS[1]) ){
					//
//					boolean presentInReg = false;
//					for (Cell cells : subjectList) {
//						if(cells.getCellName()==RHS[1]){
//						presentInReg = true;
//					}
//				}
//					if(presentInReg!=true){
//						Cell tempCell =  new Cell();
//						tempCell.setCellName(RHS[1]);
//						subjectList.add(tempCell);
//					}
					//
				}

//				}
				else{
					//RHS[1] is literal, so update it
					cellObj.setOperand2Val(Integer.parseInt(RHS[1]));
					cellObj.setOperand2("lit");
				}
				//add whatever data is available in value fields
				if(cellObj.getOperand1Val()!=-99&&cellObj.getOperand2Val()!=-99){
					cellObj.setValue(cellObj.getOperand1Val()+cellObj.getOperand2Val());
					/*for (Cell cells : subjectList) {// check if already in subj list
						if (cellObj.getCellName().equalsIgnoreCase(cells.getCellName())) {
							System.out.println(cellObj.getCellName()+ " already in subj list");
							
							existsInSubj = true;
						}
					}*/
					if(existsInSubj){
						cellObj.notifyObserver();
					}
					cellObj.setLitFlag(true);
					Logger.writeMessage("subjectList edited", Logger.DebugLevel.IN_RESULTS);
				}
//				System.out.println("Exiting else");
			}

//			for (Cell cells : subjectList) {
//				System.out.println(cells.toString());
//			}
		} else {
//			System.out.println("Detected cycle, rejecting line " + line);
			CycleList.add("Detected cycle, rejecting line " + line);
		}
	}
	
	/**
	 * Method to write to file
	 * @param outputFileName
	 */
	public void writeToFile(String outputFileName){
		FileProcessor fp = new FileProcessor(outputFileName);
		for(String cycle: CycleList){
			fp.writeLineToFile(cycle+"\n");
		}
		fp.writeLineToFile("The sum of all cell values is: "+sum);
		fp.closeFile();
	}
}