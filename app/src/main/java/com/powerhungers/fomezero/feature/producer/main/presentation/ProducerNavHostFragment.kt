package com.powerhungers.fomezero.feature.producer.main.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.powerhungers.fomezero.R
import com.powerhungers.fomezero.common.utils.ViewState
import com.powerhungers.fomezero.databinding.FragmentConsumerNavHostBinding
import com.powerhungers.fomezero.databinding.FragmentFinancesBinding
import com.powerhungers.fomezero.databinding.FragmentProducerNavHostBinding
import com.powerhungers.fomezero.feature.consumer.donation.presentation.DonationFragment
import com.powerhungers.fomezero.feature.consumer.home.presentation.ConsumerHomeFragment
import com.powerhungers.fomezero.feature.consumer.main.presentation.ConsumerSharedViewModel
import com.powerhungers.fomezero.feature.consumer.signature.presentation.SignatureFragment
import com.powerhungers.fomezero.feature.producer.basket.presentation.BasketFragment
import com.powerhungers.fomezero.feature.producer.finances.presentation.FinancesFragment
import com.powerhungers.fomezero.feature.producer.home.presentation.ProducerHomeFragment
import com.powerhungers.fomezero.feature.producer.payment.presentation.PaymentFragment
import com.powerhungers.fomezero.feature.profile.presentation.ProfileFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ProducerNavHostFragment : Fragment() {

    private val binding by lazy { FragmentProducerNavHostBinding.inflate(layoutInflater) }

    private val producerHomeFragment = ProducerHomeFragment()
    private val financesFragment = FinancesFragment()
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

}