import itertools

INSTR_CASES = [['nop','j'],
               ['nop','jal','jr'],
               ['nop','jal','jr','j']]

def generate_label_sequences(num_labels):
    return list(itertools.permutations(range(1, num_labels + 1)))

def generate_instruction_sequences(num_labels, instr_case):
    instr_set = INSTR_CASES[instr_case]
    return list(itertools.product(instr_set, repeat=num_labels))

def compose_sequences(num_labels, instr_case):
    testcases = []
    labels = generate_label_sequences(num_labels)
    instrs = generate_instruction_sequences(num_labels, instr_case)
    for i in range(len(labels)):
        for j in range(len(instrs)):
            testcase = []
            for k in range(num_labels):
                if instrs[j][k] == 'nop':
                    testcase.append('nop')
                elif instrs[j][k] == 'jr':
                    testcase.append('jr')
                else:
                    testcase.append((instrs[j][k], labels[i][k]))
            testcases.append(testcase)
    #remove duplicates
    testcases = list(set([tuple(testcase) for testcase in testcases]))
    return testcases

def judge_testcase(testcase):
    pos = 0
    allow_jr = False
    jr_pos = -1
    ret = False
    dest = len(testcase)
    vis = [False] + [False] * len(testcase)
    if testcase[dest - 1] != 'nop' and testcase[dest - 1][0] != 'jal':
        return False
    jr_present = False
    jal_present = False
    nop_counter = 0
    for i in range(dest):
        if isinstance(testcase[i], tuple):
            if testcase[i][0] == 'jal':
                jal_present = True
        if isinstance(testcase[i], str):
            if testcase[i] == 'nop':
                nop_counter += 1
            elif testcase[i] == 'jr':
                jr_present = True
        if nop_counter >= 3: #boring
            return False
    if not jr_present and jal_present: 
        return False        #boring        
            
    while True:
        if pos == dest:
            ret = True
            break
        if vis[pos]:
            break
        vis[pos] = True
        if isinstance(testcase[pos], str):
            if testcase[pos] == 'nop':
                pos += 1
            elif testcase[pos] == 'jr':
                if allow_jr:
                    pos = jr_pos
                else:
                    break
        elif isinstance(testcase[pos], tuple):
            if testcase[pos][0] == 'j':
                pos = testcase[pos][1] - 1
            elif testcase[pos][0] == 'jal':
                jr_pos = pos + 1
                pos = testcase[pos][1] - 1
                allow_jr = True
    non_vis = 0
    for i in vis:
        if not i:
            non_vis += 1
        if non_vis > 1:
            ret = False
            break
    return ret

def judge_testcases(testcases):
    passed = []
    for testcase in testcases:
        if judge_testcase(testcase):
            passed.append(testcase)
    return passed

def case_printer(testcase):
    print('******')
    for instr in testcase:
        if isinstance(instr, str):
            print(instr)
        elif isinstance(instr, tuple):
            print(instr[0], instr[1])

def main():
    i=5
    for j in range(3):
            testcases = compose_sequences(i, j)
            passed = judge_testcases(testcases)
            print('num_labels: ', i, ' instr_case: ', j)
            print('passed: ', len(passed), '/', len(testcases))
            for testcase in passed:
                case_printer(testcase)
            print('')
        
    
if __name__ == '__main__':
    main()
    #testcase = ('nop',('j',3),('jal',4),'jr','nop')
    #print(judge_testcase(testcase))
