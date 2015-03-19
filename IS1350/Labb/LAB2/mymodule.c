//
//  mymodule.c
//  LAB2
//
//  Created by Christopher State on 02/02/14.
//  Copyright (c) 2014 Christopher State. All rights reserved.
//

#include <stdio.h>
#include <linux/module.h>
#include <linux/init.h>
#include <linux/interrupt.h>

#include <linux/moduleparam.h>

#include <linux/fs.h>
#include <linux/uaccess.h>
#include <linux/types.h>

#define BUFLEN 10
static int irq;
static char interface[BUFLEN];

module_param_string(interface, interface, BUFLEN, 0);
MODULE_PARM_DESC(interface, "A network interface");
module_param(irq, int, 0);
MODULE_PARM_DESC(irq, "The IRQ of the network interface");

static irqreturn_t myinterrupt(int irq, void *dev_id, struct pt_regs *regs);

static int __init mymodule_init(void) {
    if (request_irq(irq, &myinterrupt, IRQF_SHARED, interface, &irq)) {
        printk(KERN_ERR "mymodule: cannot register IRQ %d\n", irq);
        return -EIO;
    }
    printk("Request on IRQ %d succeeded\n", irq);
    return 0;
}

static void mymodule_exit(void) {
    free_irq(irq, &irq);
    printk("Freeing IRQ %d\n", irq);
}

static int mycount = 0;
static irqreturn_t myinterrupt(int irq, void *dev_id, struct pt_regs *regs) {
    if (mycount < 10) {
        printk("Interrupt!\n");
        mycount++;
    }
    return IRQ_NONE;
}


module_init ( mymodule_init ) ;
module_exit ( mymodule_exit ) ;
MODULE_LICENSE( "GPL" ) ;
MODULE_AUTHOR("Christopher State");