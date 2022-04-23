package com.powerhungers.fomezero.feature.producer.main.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.powerhungers.fomezero.R
import com.powerhungers.fomezero.common.utils.ViewState
import com.powerhungers.fomezero.databinding.FragmentProducerNavHostBinding
import com.powerhungers.fomezero.feature.producer.basket.presentation.BasketFragment
import com.powerhungers.fomezero.feature.producer.finances.presentation.FinancesFragment
import com.powerhungers.fomezero.feature.producer.home.presentation.ProducerHomeFragment
import com.powerhungers.fomezero.feature.producer.payment.presentation.PaymentFragment
import com.powerhungers.fomezero.feature.producer.profile.presentation.ProfileFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ProducerNavHostFragment : Fragment() {

    private val binding by lazy { FragmentProducerNavHostBinding.inflate(layoutInflater) }
    private val sharedViewModel: ProducerSharedViewModel by sharedViewModel()

    private val producerHomeFragment = ProducerHomeFragment()
    private val financesFragment = FinancesFragment()
    private val basketFragment = BasketFragment()
    private val paymentFragment = PaymentFragment()
    private val profileFragment = ProfileFragment()
    private var activeFragment: Fragment = producerHomeFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBottomNav()
        addObserver()
    }

    private fun setupBottomNav() {
        handleFragmentVisibility()

        with(binding) {
            producerBottomNavHost.setOnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.home_producer ->
                        handleFragmentTransaction(producerHomeFragment)
                    R.id.finances_producer ->
                        handleFragmentTransaction(financesFragment)
                    R.id.profile_producer ->
                        handleFragmentTransaction(profileFragment)
                }
                true
            }
        }
    }

    private fun handleFragmentVisibility() {
        if (!producerHomeFragment.isAdded) {
            childFragmentManager.beginTransaction()
                .add(R.id.producerNavHostContainer, producerHomeFragment)
                .commit()
        }
        if (!financesFragment.isAdded) {
            addAndHideFragment(financesFragment)
        }
//        if (!basketFragment.isAdded) {
//            addAndHideFragment(basketFragment)
//        }
        if (!paymentFragment.isAdded) {
            addAndHideFragment(paymentFragment)
        }
        if (!profileFragment.isAdded) {
            addAndHideFragment(profileFragment)
        }
    }

    private fun addAndHideFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .add(R.id.producerNavHostContainer, fragment)
            .hide(fragment)
            .commit()
    }

    private fun handleFragmentTransaction(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .hide(activeFragment)
            .show(fragment)
            .commit()
        activeFragment = fragment
    }

    private fun addObserver() {
        observeNavigateToFinancesLiveData()
    }

    private fun observeNavigateToFinancesLiveData() {
        sharedViewModel.navigateToFinancesLiveData.observe(viewLifecycleOwner) { state ->
            if (state is ViewState.Success) {
                handleFragmentTransaction(financesFragment)
            }
        }
    }

}